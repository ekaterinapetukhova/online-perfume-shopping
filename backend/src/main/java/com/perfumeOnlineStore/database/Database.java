package com.perfumeOnlineStore.database;

import com.perfumeOnlineStore.product.Product;
import com.perfumeOnlineStore.product.ProductRepository;
import com.perfumeOnlineStore.user.User;
import com.perfumeOnlineStore.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class Database implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String[] args) {
        Product calvinKleinEuphoria = new Product(
                "Euphoria Calvin Klein",
                "Euphoria by Calvin Klein is a Amber Floral fragrance for women. Euphoria was launched in 2005. Euphoria was created by Dominique Ropion, Carlos Benaim and Loc Dong. Top notes are Pomegranate, Persimmon and Green Accord; middle notes are Black Orchid, Lotus and Champaca; base notes are Mahogany, Amber, Black Violet and Whipped Cream. This perfume is the winner of award FiFi Award Fragrance Of The Year Women`s Luxe 2006.",
                "Calvin Klein",
                200.00,
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
