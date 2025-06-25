CREATE TABLE Islemler (
    IslemID INT PRIMARY KEY IDENTITY(1,1),      -- Otomatik artan birincil anahtar
    AracID INT NOT NULL,                        -- Ara� kimli�i (Foreign Key)
    KullaniciID INT NOT NULL,                   -- Kullan�c� kimli�i (Foreign Key)
    IslemTuru NVARCHAR(20) NOT NULL,           -- "Giri�" veya "��k��" i�lemi
    Tarih DATETIME DEFAULT GETDATE(),          -- ��lem tarihi
    CONSTRAINT FK_Islemler_Araclar FOREIGN KEY (AracID) REFERENCES Araclar(AracID),
    CONSTRAINT FK_Islemler_Kullanicilar FOREIGN KEY (KullaniciID) REFERENCES Kullanicilar(KullaniciID)
);
