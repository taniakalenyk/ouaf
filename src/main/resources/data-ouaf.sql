INSERT INTO quote_of_the_day (quote_id, quote_text)
VALUES
    (1, 'Un chien qui aboie est un ami qui s''exprime.'),
    (2, 'Les jouets mâchouillés sont des trophées d''amour.'),
    (3, 'Un chien qui ronfle est une berceuse pour l''âme.'),
    (4, 'Les promenades avec un chien, c''est du sport... et du ramassage de crottes.'),
    (5, 'Avoir un chien, c''est accepter de ne plus jamais manger seul.'),
    (6, 'Les léchouilles baveuses sont des baisers sincères.'),
    (7, 'Le chien comprend "promenade" en 0.2 secondes, mais ignore "non" depuis 3 ans.'),
    (8, 'Un chien mouillé, c''est 90% d''eau et 10% de regrets.'),
    (9, 'Les empreintes de pattes sur le sol sont des traces de bonheur.'),
    (10, 'Les chiens savent qu''une maison propre est un concept, pas une réalité.'),
    (11, 'Un chien peut dormir n''importe où… sauf dans son panier, bien sûr.'),
    (12, 'Les câlins canins sont les meilleurs remèdes contre le stress.'),
    (13, 'Un chien qui rapporte la balle est un partenaire de jeu infatigable.'),
    (14, 'Un chien propre, c''est un concept théorique entre deux flaques.'),
    (15, 'Un foyer sans chien est une maison sans cœur.'),
    (16, 'La boue sur les pattes est la preuve d''une aventure réussie.'),
    (17, 'Le chien entend l''ouverture du frigo à travers trois murs et un rêve.');

INSERT INTO breeds (breed_id, breed_name)
VALUES
    (1, 'American Staffordshire Terrier'),
    (2, 'Labrador Retriever'),
    (3, 'Golden Retriever'),
    (4, 'Bouledogue Français'),
    (5, 'Beagle'),
    (6, 'Caniche'),
    (7, 'Chihuahua'),
    (8, 'Teckel'),
    (9, 'Boxer'),
    (10, 'Dalmatien'),
    (11, 'Shih Tzu'),
    (12, 'Yorkshire Terrier'),
    (13, 'Cavalier King Charles'),
    (14, 'Border Collie'),
    (15, 'Rottweiler'),
    (16, 'Staffordshire Bull Terrier'),
    (17, 'Cocker Spaniel'),
    (18, 'Bichon Frisé'),
    (19, 'Jack Russell Terrier'),
    (20, 'Siberian Husky'),
    (21, 'Dobermann'),
    (22, 'Akita Inu'),
    (23, 'Malamute d’Alaska'),
    (24, 'Saint-Bernard'),
    (25, 'Bouledogue Anglais'),
    (26, 'Carlin'),
    (27, 'West Highland White Terrier'),
    (28, 'Epagneul Breton'),
    (29, 'Shiba Inu'),
    (30, 'Berger Allemand'),
    (99, 'Autre');


INSERT INTO veterinarians (veterinarian_id, first_name, last_name, phone_number, email, clinic_name, clinic_address, clinic_city, clinic_postcode)
VALUES (
           1,
           'Claire',
           'Lemoine',
           '0654321987',
           'claire.lemoine@saintbernard-vet.fr',
           'Clinique Vétérinaire Saint-Bernard',
           '150 Avenue de Strasbourg',
           'Metz',
           '57070'
       );


INSERT INTO types (type_id, type_appointment)
VALUES
    (1, 'Dressage de Base pour Chiots'),
    (2, 'Dressage à la Laisse et au Collier'),
    (3, 'Dressage Avancé'),
    (4, 'Cours d''Agilité'),
    (5, 'Modification du Comportement'),
    (6, 'Formation pour Chiens Thérapeutes'),
    (7, 'Formation pour Chiens de Protection'),
    (8, 'Cours de Socialisation pour Chiots'),
    (9, 'Atelier de Formation Spécialisé');


INSERT INTO age_ranges (age_id, age_min, age_max)
VALUES
    (1,1,132),
    (2,1,6),
    (3,6,12),
    (4,12,24),
    (5,24, 132);

INSERT INTO lesson_cancellation_reason (lesson_cancellation_id, reason)
VALUES
    (1, 'Conditions météorologiques défavorables'),
    (2, 'Problème de santé du coach'),
    (3, 'Empêchement imprévu du coach'),
    (4, 'Nombre insuffisant de participants'),
    (5, 'Indisponibilité du terrain'),
    (6, 'Épidémie ou maladie canine contagieuse détectée'),
    (99, 'Autre motif');

INSERT INTO enrollment_cancellation_reason (enrollment_cancellation_id, reason)
VALUES
    (1, 'Conditions météorologiques défavorables'),
    (2, 'Problème de santé du propriétaire'),
    (3, 'Empêchement personnel imprévu'),
    (4, 'Erreur lors de l’inscription'),
    (5, 'Problème de santé du chien (maladie ou blessure)'),
    (99, 'Autre motif');

INSERT INTO users (user_id, user_type, first_name, last_name, email, password, photo_id, registration_date)
VALUES
    (2, 'COACH', 'Jean', 'Martin', 'coach@ouaf.academy', '$2a$10$ojxpKQ0/KtPOeAL46hSIhuhzluboDuck3c5dfTEO6gYawHKReMFNG', 'photo124.jpg', NOW()),
    (3, 'OWNER', 'Sophie', 'Bernard', 'owner@ouaf.academy', '$2a$10$ojxpKQ0/KtPOeAL46hSIhuhzluboDuck3c5dfTEO6gYawHKReMFNG', 'photo125.jpg', NOW()),
    (1, 'ADMIN', 'Tetiana', 'Lombardi', 'admin@ouaf.academy', '$2a$10$ojxpKQ0/KtPOeAL46hSIhuhzluboDuck3c5dfTEO6gYawHKReMFNG', 'adminphoto1.jpg', NOW());

INSERT INTO admin (user_id)
VALUES
    (1);

INSERT INTO owners (user_id, phone_number, address, about, birthdate, city, postcode)
VALUES
    (2, '0611121314', '45 Avenue des Champs', 'Amoureux des chiens de toutes tailles.', '1985-08-22', 'Lyon', '69001');

INSERT INTO coaches (user_id, phone_number)
VALUES
    (3, '0644455566');


INSERT INTO dogs (
    name,
    gender,
    birth_date,
    photo_id,
    weight,
    notes,
    registration_date,
    owner_id,
    primary_breed_id,
    secondary_breed_id,
    veterinarian_id
)
VALUES (
           'Bella',
           true,
           '2022-04-15',
           'bella_photo.jpg',
           8.2,
           'Chienne vive, adore jouer avec les enfants.',
           CURRENT_TIMESTAMP,
           2,
           2,
           NULL,
           NULL
       ),
       (
           'Max',
           false,
           '2020-08-09',
           'max_photo.jpg',
           14.5,
           'Chien croisé calme, habitué aux autres animaux.',
           CURRENT_TIMESTAMP,
           2,
           4,
           5,
           1
       );


INSERT INTO type_age (type_id, dog_age_id)
VALUES
    (1, 2), -- Dressage de Base pour Chiots - 1-6 months
    (1, 3), -- Dressage de Base pour Chiots - 6-12 months
    (2, 3), -- Dressage à la Laisse et au Collier - 6-12 months
    (2, 4), -- Dressage à la Laisse et au Collier - 12-24 months
    (3, 4), -- Dressage Avancé - 12-24 months
    (3, 5), -- Dressage Avancé - 24+ months
    (4, 4), -- Cours d'Agilité - 12-24 months
    (4, 5), -- Cours d'Agilité - 24+ months
    (5, 1), -- Modification du Comportement - all ages
    (6, 5), -- Formation pour Chiens Thérapeutes - 24+ months
    (7, 5), -- Formation pour Chiens de Protection - 24+ months
    (8, 2), -- Cours de Socialisation pour Chiots - 1-6 months
    (8, 3), -- Cours de Socialisation pour Chiots - 6-12 months
    (9, 1); -- Atelier de Formation Spécialisé - all ages

-- Insert into coach_specialization join table to establish the many-to-many relationship between Coach and Type
INSERT INTO coach_specialization (coach_id, type_id)
VALUES
    (3, 1), -- Luc Moreau - Dressage de Base pour Chiots
    (3, 2), -- Luc Moreau - Dressage à la Laisse et au Collier
    (3, 3), -- Luc Moreau - Dressage Avancé
    (3, 4), -- Isabelle Renard - Cours d'Agilité
    (3, 5);

INSERT INTO vaccines (vaccine_id, vaccine_name)
VALUES
    (1, 'CHP - Côtéra des Canins, Hépatite et Parvovirose'),
    (2, 'Leptospirose canine'),
    (3, 'Rage'),
    (4, 'Toux du chenil - Parainfluenza et Bordetella bronchiseptica'),
    (5, 'Lyme'),
    (6, 'Piroplasmose canine'),
    (7, 'Leishmaniose canine'),
    (8, 'Maladie de Carré ou Distemper'),
    (9, 'Hépatite contagieuse canine'),
    (10, 'Parvovirose');

INSERT INTO vaccinations (vaccination_id, first_vaccination_date, booster_date, vaccine_id, dog_id)
VALUES
    (1, '2024-01-01', '2025-01-01', 1, 1),
    (2, '2024-02-01', NULL, 2, 2),
    (3, '2024-03-01', '2025-03-01', 3, 2);
