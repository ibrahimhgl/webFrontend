CREATE TABLE Araclar (
    AracID INT PRIMARY KEY IDENTITY(1,1), -- Otomatik artan birincil anahtar
    Plaka NVARCHAR(20) NOT NULL UNIQUE,  -- Araç plakasý, eþsiz
    GirisSaati DATETIME NOT NULL,        -- Araç giriþ saati
    CikisSaati DATETIME NULL,            -- Araç çýkýþ saati (baþta boþ olabilir)
    ParkYeriID INT NOT NULL,             -- Park alaný (dýþ anahtar)
    CONSTRAINT FK_Araçlar_ParkYerleri FOREIGN KEY (ParkYeriID) REFERENCES ParkYerleri(ParkYeriID)
);
