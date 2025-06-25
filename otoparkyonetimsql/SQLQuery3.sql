CREATE TABLE Kullanicilar (
    KullaniciID INT PRIMARY KEY IDENTITY(1,1), -- Otomatik artan birincil anahtar
    KullaniciAdi NVARCHAR(50) NOT NULL UNIQUE, -- Benzersiz kullan�c� ad�
    Sifre NVARCHAR(50) NOT NULL,              -- Kullan�c� �ifresi
    Yetki NVARCHAR(20) NOT NULL DEFAULT 'Kullan�c�' -- "Y�netici" veya "Kullan�c�" rolleri
);
