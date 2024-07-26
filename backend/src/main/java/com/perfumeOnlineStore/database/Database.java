package com.perfumeOnlineStore.database;

import com.perfumeOnlineStore.entity.Category;
import com.perfumeOnlineStore.repository.CategoryRepository;
import com.perfumeOnlineStore.entity.Discount;
import com.perfumeOnlineStore.repository.DiscountRepository;
import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.repository.ProductRepository;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class Database implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final DiscountRepository discountRepository;

    @Override
    public void run(String[] args) {
        Category amber = new Category("Amber", "Amber fragrances with dominant amber are placed in a separate group thanks to their accentuated warmth and sensuality. Their opulent bouquet includes intoxicating and intensive substances such as musk, vanilla, exotic resins and wood, often accompanied with exotic flowers and spices.");
        Category aromatic = new Category("Aromatic", "Aromatic notes are usually combined of sage, rosemary, cumin, lavender and other plants which possess a very intensive grass-spicy scent. They are often combined with citrusy and spicy notes. Aromatic compositions are typical of fragrances for men.");
        Category chypre = new Category("Chypre", "This olfactive group was named after perfume Coty Chypre created in 1917. Chypre means Cyprus in French. This sharp scent is based on harmony of oak moss, labdanum, patchouli and bergamot.");
        Category citrus = new Category("Citrus", "Citrus fragrances are old and abundant. Its compositions are based on lemon, orange, bergamot, grapefruit or mandarin, with other citrusy, aromatic and tart notes for men and floral notes for women.");
        Category floral = new Category("Floral", "This largest fragrant group encompasses numerous versions of compositions with a floral heart: freshly picked flowers, flowers with aquatic, green or powdery nuances, as well as floral-aldehyde, floral-fruity and gourmand compositions.");
        Category leather = new Category("Leather", "Leather scents in various nuances, from floral, velvety compositions to tart, smoky ones are placed in this group. Scenting leather products in order to mask unpleasant scent of leather itself, since urine and faeces of cattle, as well as blood and tar had been used in its traditional production, marked the beginning of perfumery.");
        Category woody = new Category("Woody", "Opulent compositions of woody notes in a heart of perfume are accentuated with woody notes of a base. Warm, mysterious sandalwood, drier and sharper cedar and vetiver, resin-like and balmy exotic sorts are usually accompanied with aromatic and citrusy notes.");

        categoryRepository.saveAll(
                List.of(
                        amber,
                        aromatic,
                        chypre,
                        citrus,
                        floral,
                        leather,
                        woody
                ));

        Discount discount = new Discount(
                0.5,
                "Summer sale",
                LocalDateTime.of(2024, Month.JULY, 19, 12, 0, 0),
                LocalDateTime.of(2024, Month.JULY, 21, 12, 0, 0),
                "summer discounts in honor of the store opening!"
        );

        discountRepository.save(discount);

        Product calvinKleinEuphoria = new Product(
                "Euphoria Calvin Klein",
                "Euphoria by Calvin Klein is a Amber Floral fragrance for women. Euphoria was launched in 2005. Euphoria was created by Dominique Ropion, Carlos Benaim and Loc Dong. Top notes are Pomegranate, Persimmon and Green Accord; middle notes are Black Orchid, Lotus and Champaca; base notes are Mahogany, Amber, Black Violet and Whipped Cream. This perfume is the winner of award FiFi Award Fragrance Of The Year Women`s Luxe 2006.",
                "Calvin Klein",
                100.50,
                "ALCOHOL DENAT., FRAGRANCE, WATER, ACRYLATES/OCTYLACRYLAMIDE COPOLYMER, ALPHA-ISOMETHYL IONONE, BENZYL ALCOHOL, BENZYL BENZOATE, BENZYL SALICYLATE, BUTYL METHOXYDIBENZOYLMETHANE, CITRAL, CITRONELLOL, COUMARIN, ETHYLHEXYL METHOXYCINNAMATE, ETHYLHEXYL SALICYLATE, GERANIOL, HEXYL CINNAMAL, HYDROLYZED JOJOBA ESTERS, HYDROXYCITRONELLAL, ISOEUGENOL, LIMONENE, LINALOOL, PROPYLENE GLYCOL, TETRASODIUM EDTA, EXT. VIOLET 2 (CI 60730), GREEN 5 (CI 61570), RED 33 (CI 17200), YELLOW 5 (CI 19140)",
                "Pomegranate, Lotus, Orchid, Violet, Amber, Mahogany, Musk",
                50,
                Product.Gender.FEMALE,
                100
        );

        Product dolceGabbanaTheOne = new Product(
                "The One Dolce&Gabbana",
                "Dazzle everyone with your uniqueness. Dolce & Gabbana The One Eau de Parfum combines modern fruity notes with a classic perfume palette of white flowers. This contrast is also what gives the fragrance its strength and uniqueness. Because that’s what every single one of us is: Unique. The One.",
                "Dolce&Gabbana",
                425.50,
                "ALCOHOL DENAT., PARFUM/FRAGRANCE, AQUA/WATER, ETHYLHEXYL METHOXYCINNAMATE, DIETHYLAMINO HYDROXYBENZOYL HEXYL BENZOATE, PROPYLENE GLYCOL, METHYLPARABEN, BENZYL SALICYLATE, LIMONENE, HEXYL CINNAMAL, GERANIOL, LINALOOL, CITRONELLOL, BENZYL BENZOATE, HYDROXYCITRONELLAL, , BENZYL ALCOHOL, CITRAL, BENZYL CINNAMATE, ISOEUGENOL, AMYL CINNAMAL, CINNAMAL, EUGENOL, CI 15985/YELLOW 6, CI 60730/EXT·VIOLET 2.",
                "Bergamot, Peach, lychee, Tangerine, Jasmine, Lily Of The Valley, Lily, Vanilla, Musk, Vetiver, Plum, Amber",
                24,
                Product.Gender.FEMALE,
                75
        );


        productRepository.saveAll(
                List.of(
                    calvinKleinEuphoria,
                    dolceGabbanaTheOne
                )
        );

        User user = new User(
                "Kate",
                "Petukhova",
                "katepthv12@gmail.com",
                "12345678",
                "12345678",
                "Street 1",
                "Poland",
                "Katowice",
                "44-021"
        );

        userRepository.save(user);
    }
}
