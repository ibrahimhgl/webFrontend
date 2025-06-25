CREATE TABLE Kullanicilar (
    KullaniciID INT PRIMARY KEY IDENTITY(1,1), -- Otomatik artan birincil anahtar
    KullaniciAdi NVARCHAR(50) NOT NULL UNIQUE, -- Benzersiz kullanýcý adý
    Sifre NVARCHAR(50) NOT NULL,              -- Kullanýcý þifresi
    Yetki NVARCHAR(20) NOT NULL DEFAULT 'Kullanýcý' -- "Yönetici" veya "Kullanýcý" rolleri
);
