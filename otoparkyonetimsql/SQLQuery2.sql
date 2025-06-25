CREATE TABLE ParkYerleri (
    ParkYeriID INT PRIMARY KEY IDENTITY(1,1), -- Otomatik artan birincil anahtar
    Konum NVARCHAR(50) NOT NULL,            -- Park yerinin bulundu�u konum (�rne�in: A1, B2)
    Durum NVARCHAR(20) NOT NULL DEFAULT 'Bo�' -- "Bo�" veya "Dolu" gibi durumlar
);

