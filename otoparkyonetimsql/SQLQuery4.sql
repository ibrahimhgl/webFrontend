CREATE TABLE Islemler (
    IslemID INT PRIMARY KEY IDENTITY(1,1),      -- Otomatik artan birincil anahtar
    AracID INT NOT NULL,                        -- Araç kimliði (Foreign Key)
    KullaniciID INT NOT NULL,                   -- Kullanýcý kimliði (Foreign Key)
    IslemTuru NVARCHAR(20) NOT NULL,           -- "Giriþ" veya "Çýkýþ" iþlemi
    Tarih DATETIME DEFAULT GETDATE(),          -- Ýþlem tarihi
    CONSTRAINT FK_Islemler_Araclar FOREIGN KEY (AracID) REFERENCES Araclar(AracID),
    CONSTRAINT FK_Islemler_Kullanicilar FOREIGN KEY (KullaniciID) REFERENCES Kullanicilar(KullaniciID)
);
