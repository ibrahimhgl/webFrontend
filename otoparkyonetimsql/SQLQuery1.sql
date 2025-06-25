CREATE TABLE Araclar (
    AracID INT PRIMARY KEY IDENTITY(1,1), -- Otomatik artan birincil anahtar
    Plaka NVARCHAR(20) NOT NULL UNIQUE,  -- Ara� plakas�, e�siz
    GirisSaati DATETIME NOT NULL,        -- Ara� giri� saati
    CikisSaati DATETIME NULL,            -- Ara� ��k�� saati (ba�ta bo� olabilir)
    ParkYeriID INT NOT NULL,             -- Park alan� (d�� anahtar)
    CONSTRAINT FK_Ara�lar_ParkYerleri FOREIGN KEY (ParkYeriID) REFERENCES ParkYerleri(ParkYeriID)
);
