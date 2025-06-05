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
    (16, 'Staffordshire Terrier'),
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
    (31, 'Weimaraner'),
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
       ),
       (
           2,
           'Romain',
           'Lemoine',
           '0654321987',
           'romain.lemoine@saintbernard-vet.fr',
           'Clinique Vétérinaire de Strasbourg',
           '77 rue Principale',
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

INSERT INTO users (user_id, user_type, first_name, last_name, email, password, photo_id, registration_date)
VALUES
    (1, 'ADMIN', 'Admin', 'ADMIN', 'admin@ouaf.academy', '$2a$10$ojxpKQ0/KtPOeAL46hSIhuhzluboDuck3c5dfTEO6gYawHKReMFNG', '17.jpg', CURRENT_TIMESTAMP),
    (2, 'COACH', 'CocoCoach', 'COACH', 'coach@ouaf.academy', '$2a$10$ojxpKQ0/KtPOeAL46hSIhuhzluboDuck3c5dfTEO6gYawHKReMFNG', '6.jpg', CURRENT_TIMESTAMP),
    (4, 'OWNER', 'Ernesto', 'OWNER', 'owner2@ouaf.academy', '$2a$10$ojxpKQ0/KtPOeAL46hSIhuhzluboDuck3c5dfTEO6gYawHKReMFNG', '9.jpg', CURRENT_TIMESTAMP),
    (3, 'OWNER', 'Tania', 'OWNER', 'owner@ouaf.academy', '$2a$10$ojxpKQ0/KtPOeAL46hSIhuhzluboDuck3c5dfTEO6gYawHKReMFNG', '8.jpg', CURRENT_TIMESTAMP);

INSERT INTO enrollment_cancellation_reason (enrollment_cancellation_id, reason)
VALUES
    (1, 'Conditions météorologiques défavorables'),
    (2, 'Problème de santé du propriétaire'),
    (3, 'Empêchement personnel imprévu'),
    (4, 'Erreur lors de l’inscription'),
    (5, 'Problème de santé du chien (maladie ou blessure)'),
    (99, 'Autre motif');

INSERT INTO admin (user_id)
VALUES
    (1);

INSERT INTO owners (user_id, phone_number, address, about, birthdate, city, postcode)
VALUES
    (3, '0707880788', '150 avenue de Nancy', 'Heureuse propriétaire de Maybe et Baily, passionnée par les activités en plein air avec mes compagnons à quatre pattes.', '1992-06-07', 'Metz', '57000'),
    (4, '0707880787', '150 avenue de Nancy', 'Propriétaire de Kiki et Koko.', '1996-12-06', 'Metz', '57000');

INSERT INTO coaches (user_id, phone_number)
VALUES
    (2, '0644455566');


INSERT INTO dogs (dog_id,
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
                  veterinarian_id)
VALUES
    (1,
     'Bella',
     true,
     '2025-04-15',
     '3.jpg',
     8.2,
     'Je n’ai pas de maladies ou allergies. J’aime jouer, courir, manger et embêter mon ami chat.',
     CURRENT_TIMESTAMP,
     3,
     10,
     NULL,
     NULL),

    (2,
     'Lou',
     true,
     '2023-08-09',
     '15.jpg',
     14.5,
     'Chien croisé calme, habitué aux autres animaux.',
     CURRENT_TIMESTAMP,
     3,
     4,
     5,
     2),

    (3,
     'Mistral',
     false,
     '2025-05-09',
     '7.jpg',
     14.5,
     'Chien croisé calme, habitué aux autres animaux.',
     CURRENT_TIMESTAMP,
     3,
     31,
     NULL,
     1),

    (4,
     'Nala',
     true,
     '2022-08-12',
     '4.jpg',
     25.0,
     'Golden Retriever joueuse et sociable.',
     CURRENT_TIMESTAMP,
     4,
     12,
     NULL,
     2),

    (5,
     'Simba',
     false,
     '2021-11-25',
     '5.jpg',
     10.0,
     'Shiba Inu indépendant mais affectueux.',
     CURRENT_TIMESTAMP,
     4,
     8,
     NULL,
     2),

    (6,
     'Daisy',
     true,
     '2023-02-17',
     '6.jpg',
     6.5,
     'Petite Jack Russell vive et curieuse.',
     CURRENT_TIMESTAMP,
     4,
     6,
     NULL,
     1);

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
    (2, 1), -- Luc Moreau - Dressage de Base pour Chiots
    (2, 2), -- Luc Moreau - Dressage à la Laisse et au Collier
    (2, 3), -- Luc Moreau - Dressage Avancé
    (2, 4), -- Luc Moreau - Cours d'Agilité
    (2, 5);

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

INSERT INTO templates (template_id, capacity, price, price_correction, type_id, age_id)
VALUES
    (1, 8, 45.00, NULL, 1, 2),         -- Dressage de Base pour Chiots (1-6 months) - 45€ - 60min
    (2, 8, 45.00, NULL, 1, 3),         -- Dressage de Base pour Chiots (6-12 months) - 45€ - 60min
    (3, 6, 55.00, NULL, 2, 3),         -- Dressage à la Laisse et au Collier (6-12 months) - 55€ - 60min
    (4, 6, 65.00, NULL, 4, 4),         -- Cours d'Agilité (12-24 months) - 65€ - 90min
    (5, 4, 75.00, -10.00, 5, 1),       -- Modification du Comportement (all ages) - 65€ (75€-10€) - 60min
    (6, 4, 85.00, NULL, 3, 4),         -- Dressage Avancé (12-24 months) - 85€ - 90min
    (7, 4, 85.00, NULL, 3, 5),         -- Dressage Avancé (24+ months) - 85€ - 90min
    (8, 10, 35.00, NULL, 8, 2),        -- Cours de Socialisation pour Chiots (1-6 months) - 35€ - 45min
    (9, 12, 25.00, NULL, 9, 1);        -- Atelier de Formation Spécialisé (all ages) - 25€ - 45min

INSERT INTO lessons (lesson_id, start_date_time, end_date_time, location, lesson_cancellation_id, coach_id, template_id)
VALUES
    (1, '2025-06-10 10:00:00', '2025-06-10 11:00:00', 'Terrain A', NULL, 2, 1), -- Dressage chiot 60min
    (2, '2025-06-12 18:00:00', '2025-06-12 19:30:00', 'Terrain B', NULL, 2, 4), -- Agility 90min
    (3, '2025-06-15 15:00:00', '2025-06-15 16:00:00', 'Salle 1', NULL, 2, 5),   -- Comportement 60min
    (4, '2025-06-18 09:00:00', '2025-06-18 09:45:00', 'Atelier C', NULL, 2, 9); -- Atelier 45min

INSERT INTO enrollments (enrollment_id, date_creation, payment_date, dog_id, lesson_id, enrollment_cancellation_id, admin_id)
VALUES
    (1, '2025-06-01 10:00:00', '2025-06-02 09:00:00', 1, 1, NULL, 1), -- Max inscrit au dressage chiot, payé
    (2, '2025-06-01 10:10:00', '2025-06-02 09:10:00', 2, 2, NULL, 1), -- Bella à l’agility, payé
    (3, '2025-06-01 10:20:00', NULL, 3, 3, NULL, 1),                 -- Rocky comportement, en attente (pas encore payé)
    (4, '2025-06-01 10:30:00', '2025-06-03 08:30:00', 4, 4, NULL, 1), -- Luna à un atelier, payé
    (5, '2025-06-01 10:40:00', NULL, 5, 3, 1, 1);                    -- Charlie a annulé comportement, raison #1
