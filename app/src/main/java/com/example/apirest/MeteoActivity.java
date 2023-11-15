package com.example.apirest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MeteoActivity extends AppCompatActivity {

    private OpenWeatherServices services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meteo);

        services = RetroFitClientInstance.getRetrofitInstance().create(OpenWeatherServices.class);

        EditText editTextCity = findViewById(R.id.editTextCity);
        Button btnGetWeather = findViewById(R.id.btnGetWeather);

        btnGetWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = editTextCity.getText().toString();

                if (!city.isEmpty()) {
                    // Appel à l'API avec la ville spécifiée
                    Call<Forecast> call = services.getForecastByCity(city);
                    call.enqueue(new Callback<Forecast>() {
                        @Override
                        public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                            if (response.isSuccessful()) {
                                Forecast forecast = response.body();
                                if (forecast != null) {
                                    Temperature temperature = forecast.getTemperature();

                                    TextView temperatureTextView = findViewById(R.id.textViewTemp);

                                    temperatureTextView.setText("Température : " + temperature.getTemp() + " °C");

                                    Weather conditions = forecast.getConditions()[0];
                                    TextView conditionsTextView = findViewById(R.id.textViewCond);
                                    conditionsTextView.setText("Conditions : " + conditions.getConditions());

                                    afficherRecetteEnFonctionDesConditions(conditions.getConditions());
                                }
                            } else {
                                Toast.makeText(MeteoActivity.this, "Une erreur est survenue !", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Forecast> call, Throwable t) {
                            Toast.makeText(MeteoActivity.this, "Une erreur est survenue !", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(MeteoActivity.this, "Veuillez saisir une ville", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void afficherRecetteEnFonctionDesConditions(String conditions) {
        // Logique pour choisir une recette en fonction des conditions météorologiques
        Recettes recette = choisirRecetteEnFonctionDesConditions(conditions);

        // Afficher les détails de la recette dans l'interface utilisateur
        afficherDetailsRecette(recette);
    }

    private Recettes choisirRecetteEnFonctionDesConditions(String conditions) {
        if (conditions.contains("pluvieux")) {
            return new Recettes("Soupe réconfortante", "Parfaite pour les journées pluvieuses", "1. Préparez les légumes...\n2. Cuisez à feu doux...");
        } else if (conditions.contains("ensoleillé")) {
            return new Recettes("Salade fraîche", "Idéale par temps ensoleillé", "1. Lavez et coupez les légumes...\n2. Préparez la vinaigrette...");
        } else if (conditions.contains("enneigé")) {
            return new Recettes("Chocolat chaud", "Parfait pour les journées enneigées", "1. Chauffez le lait...\n2. Ajoutez le chocolat en poudre...\n3. Saupoudrez de cannelle...");
        } else if (conditions.contains("couvert")) {
            return new Recettes("Casserole de poulet et légumes", "Parfait pour les jours couverts", "1. Coupez le poulet et les légumes...\n2. Disposez-les dans un plat allant au four...\n3. Ajoutez des épices et faites cuire au four...");
        } else if (conditions.contains("venteux")) {
            return new Recettes("Tourte au poulet", "Parfaite pour les journées venteuses", "1. Préparez la pâte et la garniture...\n2. Enfournez jusqu'à ce que la croûte soit dorée...");
        } else if (conditions.contains("nuageux")) {
            return new Recettes("Pâtes aux champignons", "Réconfortant par temps nuageux", "1. Cuisinez les pâtes selon les instructions...\n2. Préparez la sauce aux champignons...");
        } else {
            // Recette par défaut si les conditions ne correspondent à aucune logique connue
            return new Recettes("Recette par défaut", "Aucune recette spécifique pour ces conditions", "Suivez les instructions générales...");
        }
    }

    private void afficherDetailsRecette(Recettes recette) {
        // Afficher les détails de la recette dans l'interface utilisateur
        TextView nomRecetteTextView = findViewById(R.id.textViewRecetteNom);
        TextView descriptionRecetteTextView = findViewById(R.id.textViewRecetteDesc);
        TextView instructionsRecetteTextView = findViewById(R.id.textViewRecetteInst);

        nomRecetteTextView.setText(recette.getNom());
        descriptionRecetteTextView.setText(recette.getDescription());
        instructionsRecetteTextView.setText(recette.getInstructions());
    }
}
