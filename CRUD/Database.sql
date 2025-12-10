CREATE DATABASE pbob2crud;
USE pbob2crud;
CREATE TABLE mahasiswa (
    nim VARCHAR(10) PRIMARY KEY,
    nama VARCHAR(50),
    jurusan VARCHAR(30)
);
INSERT INTO mahasiswa (nim, nama, jurusan) VALUES ('101', 'Budi', 'Informatika');
INSERT INTO mahasiswa (nim, nama, jurusan) VALUES ('102', 'Siti', 'Sistem Informasi');
