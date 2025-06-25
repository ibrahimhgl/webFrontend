CREATE TABLE ParkYerleri (
    ParkYeriID INT PRIMARY KEY IDENTITY(1,1), -- Otomatik artan birincil anahtar
    Konum NVARCHAR(50) NOT NULL,            -- Park yerinin bulunduðu konum (örneðin: A1, B2)
    Durum NVARCHAR(20) NOT NULL DEFAULT 'Boþ' -- "Boþ" veya "Dolu" gibi durumlar
);

