package com.perfumeOnlineStore.database;

import com.perfumeOnlineStore.entity.*;
import com.perfumeOnlineStore.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class Database implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CategoryRepository categoryRepository;
    private final DiscountRepository discountRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String[] args) {
        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");

        roleRepository.saveAll(
                List.of(
                        roleAdmin,
                        roleUser
                )
        );

        Category amber = Category.builder()
                .name("Amber")
                .description("Amber fragrances with dominant amber are placed in a separate group thanks to their accentuated warmth and sensuality. Their opulent bouquet includes intoxicating and intensive substances such as musk, vanilla, exotic resins and wood, often accompanied with exotic flowers and spices.")
                .build();
        Category aromatic = Category.builder()
                .name("Aromatic")
                .description("Aromatic notes are usually combined of sage, rosemary, cumin, lavender and other plants which possess a very intensive grass-spicy scent. They are often combined with citrusy and spicy notes. Aromatic compositions are typical of fragrances for men.")
                .build();
        Category chypre = Category.builder()
                .name("Chypre")
                .description("This olfactive group was named after perfume Coty Chypre created in 1917. Chypre means Cyprus in French. This sharp scent is based on harmony of oak moss, labdanum, patchouli and bergamot.")
                .build();
        Category citrus = Category.builder()
                .name("Citrus")
                .description("Citrus fragrances are old and abundant. Its compositions are based on lemon, orange, bergamot, grapefruit or mandarin, with other citrusy, aromatic and tart notes for men and floral notes for women.")
                .build();
        Category floral = Category.builder()
                .name("Floral")
                .description("This largest fragrant group encompasses numerous versions of compositions with a floral heart: freshly picked flowers, flowers with aquatic, green or powdery nuances, as well as floral-aldehyde, floral-fruity and gourmand compositions.")
                .build();
        Category leather = Category.builder()
                .name("Leather")
                .description("Leather scents in various nuances, from floral, velvety compositions to tart, smoky ones are placed in this group. Scenting leather products in order to mask unpleasant scent of leather itself, since urine and faeces of cattle, as well as blood and tar had been used in its traditional production, marked the beginning of perfumery.")
                .build();
        Category woody = Category.builder()
                .name("Woody")
                .description("Opulent compositions of woody notes in a heart of perfume are accentuated with woody notes of a base. Warm, mysterious sandalwood, drier and sharper cedar and vetiver, resin-like and balmy exotic sorts are usually accompanied with aromatic and citrusy notes.")
                .build();

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

        Product calvinKleinEuphoria = Product.builder()
                .name("Euphoria Calvin Klein")
                .description("Euphoria by Calvin Klein is a Oriental Floral fragrance for women. Euphoria was launched in 2005. Euphoria was created by Dominique Ropion, Carlos Benaim and Loc Dong. Top notes are Pomegranate, Persimmon and Green Accord; middle notes are Black Orchid, Lotus and Champaca; base notes are Mahogany, Amber, Black Violet and Whipped Cream. This perfume is the winner of award FiFi Award Fragrance Of The Year Women`s Luxe 2006.")
                .brand("Calvin Klein")
                .price(300.00)
                .components("ALCOHOL DENAT., FRAGRANCE, WATER, ACRYLATES/OCTYLACRYLAMIDE COPOLYMER, ALPHA-ISOMETHYL IONONE, BENZYL ALCOHOL, BENZYL BENZOATE, BENZYL SALICYLATE, BUTYL METHOXYDIBENZOYLMETHANE, CITRAL, CITRONELLOL, COUMARIN, ETHYLHEXYL METHOXYCINNAMATE, ETHYLHEXYL SALICYLATE, GERANIOL, HEXYL CINNAMAL, HYDROLYZED JOJOBA ESTERS, HYDROXYCITRONELLAL, ISOEUGENOL, LIMONENE, LINALOOL, PROPYLENE GLYCOL, TETRASODIUM EDTA, EXT. VIOLET 2 (CI 60730), GREEN 5 (CI 61570), RED 33 (CI 17200), YELLOW 5 (CI 19140)")
                .scentGroups("Owoc granatu, lotos, orchidea, fiołek, bursztyn, mahoń, piżmo, orientalne, kwiatowe")
                .volume(160)
                .quantity(20)
                .gender(Product.Gender.FEMALE)
                .build();

        calvinKleinEuphoria.setCategory(amber);

        productRepository.save(calvinKleinEuphoria);

        User admin = User.builder()
                .name("Ekaterina")
                .surname("Petukhova")
                .email("katepthv12@gmail.com")
                .password(passwordEncoder.encode("Pea12122000!"))
                .phoneNumber("12345678")
                .address("Street 1")
                .country("Poland")
                .city("Katowice")
                .postcode("40-032")
                .build();

        admin.setRoles(
                Set.of(roleAdmin)
        );

        userRepository.save(admin);
    }
}
