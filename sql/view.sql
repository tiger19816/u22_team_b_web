
#[v_couple]
#妻情報＋夫情報をまとめたVIEW
CREATE VIEW v_couple AS 
SELECT
female.id AS female_id,
female.name AS female_name,
female.birthday AS female_birthday,
female.password AS female_password,
female.card_number AS card_number,
female.card_expiration_date AS card_expiration_date,
female.card_security_code AS card_security_code,
female.card_nominee AS card_nominee,
female.point_latitude AS point_latitude,
female.point_longitude AS point_longitude,
female.male_id AS male_id,
male.name AS male_name,
male.mail AS mail, 
male.password AS male_password, 
male.birthday AS male_birthday, 
male.height AS height, 
male.weight AS weight, 
male.profession AS profession
FROM female INNER JOIN male ON female.male_id = male.id
ORDER BY female_id
;