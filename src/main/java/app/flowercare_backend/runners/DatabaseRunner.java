package app.flowercare_backend.runners;

import app.flowercare_backend.entities.AppUser;
import app.flowercare_backend.entities.Plant;
import app.flowercare_backend.entities.UserPlant;
import app.flowercare_backend.repository.PlantRepository;
import app.flowercare_backend.repository.UserPlantRepository;
import app.flowercare_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DatabaseRunner implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PlantRepository plantRepository;

    private final UserPlantRepository userPlantRepository;

    @Override
    public void run(String... args) throws Exception {
        AppUser lukas = new AppUser();
        lukas.setUsername("Lukas");
        lukas.setPassword("heslo");
        userRepository.save(lukas);

        AppUser lucka = new AppUser();
        lucka.setUsername("Lucka");
        lucka.setPassword("heslo");
        userRepository.save(lucka);

        AppUser eva = new AppUser();
        eva.setUsername("Eva");
        eva.setPassword("heslo");
        userRepository.save(eva);

        Plant basil = new Plant();
        basil.setName("basil");
        basil.setWateringRequirements("Water basil plants every 1 to 2 days, ensuring the soil remains moist but not soggy. During hot, dry periods, more frequent watering may be necessary. Always check the top inch of soil for dryness before watering.");
        basil.setFertilizerRequirements("Use a balanced, water-soluble fertilizer with an N-P-K ratio of 10-10-10 or similar. Organic options, such as fish emulsion or compost tea, are also excellent for basil and can enhance flavor.");
        basil.setSunRequirements("Basil requires at least 6 to 8 hours of direct sunlight daily. If grown indoors, a south-facing window or a grow light can provide sufficient light. Too little light will result in leggy plants and reduced flavor.");
        basil.setFertilizerInstructions("Fertilize basil every 4 to 6 weeks during the growing season. Use a balanced, water-soluble fertilizer, diluted to half the recommended strength, to avoid over-fertilization which can affect the plant's flavor.");
        plantRepository.save(basil);

        Plant strawberry = new Plant();
        strawberry.setName("strawberry");
        strawberry.setWateringRequirements("Water strawberry plants every day to keep the soil moist, especially during the first few weeks after planting and during dry spells. Strawberries require about 1 to 1.5 inches of water weekly. Use mulch to help retain soil moisture.");
        strawberry.setFertilizerRequirements("Use a balanced, all-purpose fertilizer with an N-P-K ratio of 10-10-10 or 12-12-12. Apply at planting time and again in late August for perennial beds. For organic options, compost or well-rotted manure can be effective.");
        strawberry.setSunRequirements("Strawberries require full sun, at least 6 to 8 hours of direct sunlight per day. They thrive in well-drained, fertile soils with a pH between 5.5 and 6.8. Proper sunlight is crucial for fruit production.");
        strawberry.setFertilizerInstructions("Fertilize strawberries at planting time and again in late summer after harvest. Do not over-fertilize, especially with nitrogen, as it can lead to lush foliage with poor fruiting. Use a balanced fertilizer at the rate recommended on the label, or apply compost or well-rotted manure.");
        plantRepository.save(strawberry);

        Plant parsley = new Plant();
        parsley.setName("parsley");
        parsley.setWateringRequirements("Keep the soil evenly moist, watering parsley plants once or twice a week depending on weather conditions. Parsley likes consistent moisture but not waterlogged soil.");
        parsley.setFertilizerRequirements("Use a balanced, all-purpose fertilizer every 4 to 6 weeks. Organic options like compost or fish emulsion work well and encourage lush growth.");
        parsley.setSunRequirements("Parsley requires full sun to partial shade, with at least 6 hours of sunlight per day. It can tolerate more shade than most herbs but prefers bright light.");
        parsley.setFertilizerInstructions("Apply a balanced liquid fertilizer every 4 to 6 weeks during the growing season. If using compost or manure, apply at the beginning of the planting season.");
        plantRepository.save(parsley);

        Plant chives = new Plant();
        chives.setName("chives");
        chives.setWateringRequirements("Water chives regularly, ensuring the soil is moist but not soggy. Reduce watering frequency once established. They need about 1 inch of water per week.");
        chives.setFertilizerRequirements("Chives are not heavy feeders but benefit from occasional feeding with a balanced, all-purpose fertilizer or compost application once or twice a season.");
        chives.setSunRequirements("Chives thrive in full sun but can tolerate partial shade. They need at least 5-6 hours of sunlight daily to develop their full flavor.");
        chives.setFertilizerInstructions("Fertilize chives lightly with a balanced, all-purpose fertilizer in spring and mid-summer, or use compost as a top dressing.");
        plantRepository.save(chives);

        Plant rosemary = new Plant();
        rosemary.setName("rosemary");
        rosemary.setWateringRequirements("Water rosemary plants deeply but infrequently, allowing the soil to dry out between watering. Overwatering or poor drainage can lead to root rot.");
        rosemary.setFertilizerRequirements("Rosemary requires little fertilizer. If growth seems slow, apply a balanced, all-purpose fertilizer sparingly in the spring.");
        rosemary.setSunRequirements("Rosemary needs full sun, at least 6-8 hours of direct sunlight daily. It thrives in well-draining soil and can tolerate drought once established.");
        rosemary.setFertilizerInstructions("If necessary, fertilize rosemary in the spring with a balanced, slow-release fertilizer at the rate recommended on the package.");
        plantRepository.save(rosemary);

        Plant oregano = new Plant();
        oregano.setName("oregano");
        oregano.setWateringRequirements("Water oregano plants when the soil is dry to the touch, about once a week. Avoid overwatering, as oregano prefers drier conditions.");
        oregano.setFertilizerRequirements("Oregano does not require much fertilizer. If desired, apply a light feeding of balanced, all-purpose fertilizer at the beginning of the growing season.");
        oregano.setSunRequirements("Oregano requires full sun to grow vigorously, at least 6-8 hours of direct sunlight each day. It prefers well-draining soil with a neutral to slightly alkaline pH.");
        oregano.setFertilizerInstructions("Fertilize oregano lightly in the spring with an all-purpose fertilizer, if at all. Over-fertilizing can reduce its flavor intensity.");
        plantRepository.save(oregano);

        Plant mint = new Plant();
        mint.setName("mint");
        mint.setWateringRequirements("Mint likes moist, but not waterlogged, soil. Water when the top inch of soil feels dry to the touch. Mint can be more water-loving than many other herbs.");
        mint.setFertilizerRequirements("Mint benefits from a light application of a balanced, all-purpose fertilizer in the spring. Alternatively, compost or well-rotted manure can provide sufficient nutrients.");
        mint.setSunRequirements("Mint grows best in full to partial sun, requiring at least 4-6 hours of direct sunlight daily. However, in very hot climates, afternoon shade can prevent scorching.");
        mint.setFertilizerInstructions("Apply a balanced, all-purpose fertilizer sparingly in the early spring. Too much fertilizer can lead to leggy growth and less flavorful leaves.");
        plantRepository.save(mint);

        Plant cilantro = new Plant();
        cilantro.setName("cilantro");
        cilantro.setWateringRequirements("Water cilantro regularly to keep the soil moist, especially in dry conditions. Avoid overwatering to prevent root rot.");
        cilantro.setFertilizerRequirements("Use a light application of a balanced fertilizer every 4 to 6 weeks. Organic options like compost can also be beneficial.");
        cilantro.setSunRequirements("Cilantro needs full sun or partial shade with at least 4-6 hours of sunlight per day.");
        cilantro.setFertilizerInstructions("Apply fertilizer every month during the growing season, using a balanced, water-soluble fertilizer.");
        plantRepository.save(cilantro);

        Plant thyme = new Plant();
        thyme.setName("thyme");
        thyme.setWateringRequirements("Water thyme sparingly; it prefers drier conditions. Allow the soil to dry out between waterings.");
        thyme.setFertilizerRequirements("Thyme generally does not need much fertilizer, but a light feeding at the start of the growing season can promote growth.");
        thyme.setSunRequirements("Thyme requires full sun, at least 6 hours of direct sunlight each day.");
        thyme.setFertilizerInstructions("If fertilizing, use a low-strength, balanced fertilizer at the beginning of the growing season.");
        plantRepository.save(thyme);

        Plant lavender = new Plant();
        lavender.setName("lavender");
        lavender.setWateringRequirements("Water once or twice a week until established. Lavender is drought-tolerant and prefers the soil to be slightly dry.");
        lavender.setFertilizerRequirements("Lavender requires little to no fertilizer. If growth is slow, a light application in early spring may help.");
        lavender.setSunRequirements("Lavender needs full sun, at least 6-8 hours of direct sunlight daily.");
        lavender.setFertilizerInstructions("If necessary, use a small amount of slow-release fertilizer in the spring.");
        plantRepository.save(lavender);

        Plant marjoram = new Plant();
        marjoram.setName("marjoram");
        marjoram.setWateringRequirements("Water marjoram regularly but allow the soil to dry slightly between waterings.");
        marjoram.setFertilizerRequirements("Feed marjoram with a balanced, water-soluble fertilizer every 4-6 weeks during the growing season.");
        marjoram.setSunRequirements("Marjoram prefers full sun but will tolerate partial shade. It needs at least 4-6 hours of sunlight per day.");
        marjoram.setFertilizerInstructions("Fertilize marjoram with a diluted solution to prevent nutrient overload, which can diminish flavor.");
        plantRepository.save(marjoram);

        Plant sage = new Plant();
        sage.setName("sage");
        sage.setWateringRequirements("Water sage sparingly; it is drought tolerant and does well in dry conditions once established.");
        sage.setFertilizerRequirements("Sage generally does not require fertilizer, but a light application in the spring can promote fuller growth.");
        sage.setSunRequirements("Sage needs full sun, at least 6-8 hours of direct sunlight daily.");
        sage.setFertilizerInstructions("If you choose to fertilize, use a very mild, balanced fertilizer at the beginning of the growing season.");
        plantRepository.save(sage);

        Plant lemonBalm = new Plant();
        lemonBalm.setName("lemon balm");
        lemonBalm.setWateringRequirements("Keep soil consistently moist but not waterlogged. Water more frequently in higher temperatures.");
        lemonBalm.setFertilizerRequirements("A light application of balanced, all-purpose fertilizer can be applied every 4-6 weeks.");
        lemonBalm.setSunRequirements("Lemon balm prefers full sun but will grow in partial shade. It needs at least 4 hours of sunlight daily.");
        lemonBalm.setFertilizerInstructions("Use a diluted fertilizer to avoid overfeeding, which can impact the quality of the leaves.");
        plantRepository.save(lemonBalm);

        Plant watercress = new Plant();
        watercress.setName("watercress");
        watercress.setWateringRequirements("Watercress requires constant moisture and should be grown in wet, boggy conditions.");
        watercress.setFertilizerRequirements("Use a half-strength liquid fertilizer every 4 weeks during active growth.");
        watercress.setSunRequirements("Watercress grows best in partial shade but can tolerate full sun in cooler climates.");
        watercress.setFertilizerInstructions("Regular feeding with a diluted liquid fertilizer helps maintain vigorous growth.");
        plantRepository.save(watercress);









        UserPlant lukas_basil = new UserPlant();
        lukas_basil.setUser(lukas);
        lukas_basil.setPlant(basil);
        userPlantRepository.save(lukas_basil);

        UserPlant lukas_strawberry = new UserPlant();
        lukas_strawberry.setUser(lukas);
        lukas_strawberry.setPlant(strawberry);
        userPlantRepository.save(lukas_strawberry);

        UserPlant lukas_rosemary = new UserPlant();
        lukas_rosemary.setUser(lukas);
        lukas_rosemary.setPlant(rosemary);
        userPlantRepository.save(lukas_rosemary);

        UserPlant lucka_mint = new UserPlant();
        lucka_mint.setUser(lucka);
        lucka_mint.setPlant(mint);
        userPlantRepository.save(lucka_mint);

        UserPlant lucka_oregano = new UserPlant();
        lucka_oregano.setUser(lucka);
        lucka_oregano.setPlant(oregano);
        userPlantRepository.save(lucka_oregano);




    }
}
