![mockup](https://github.com/sulthonaw/aplikasi-reporting-java-gui/blob/main/mockup.png)
# 📊 Aplikasi Java Reporting

Aplikasi ini merupakan proyek tugas mata kuliah **Basis Data** yang dibuat menggunakan **Java JDBC** dan **JasperReports** untuk menampilkan laporan data dosen dan departemen dari basis data SQL Server.

## 👤 Informasi Mahasiswa

- **Nama:** Muhammad Sulthon Aulia Wijaya  
- **NIM:** 24515020711103  

---

## 🚀 Get Started

Ikuti langkah-langkah berikut untuk menjalankan aplikasi ini:

1. **Clone Repository**

   ```bash
   git clone https://github.com/sulthonaw/aplikasi-reporting-java-gui.git
   cd aplikasi-reporting-java-gui
   ```

2. **Install Dependency**

   Pastikan library JDBC dan JasperReports telah tersedia. 
   Jika menggunakan **Maven**, tambahkan dependency-nya pada file `pom.xml`. Jika menggunakan **Gradle**, tambahkan pada file `build.gradle`. 
   Jika menggunakan cara manual, pastikan file `.jar` yang dibutuhkan sudah disertakan dalam classpath proyek.

3. **Konfigurasi Database**

   - Sesuaikan koneksi JDBC di file konfigurasi atau kode (`App.java`) agar sesuai dengan server dan kredensial database-mu.

4. **Jalankan Aplikasi**

   Jalankan `App.java` melalui IDE (NetBeans/IntelliJ/Eclipse) atau terminal:

   ```bash
   javac App.java
   java App
   ```

---

## 🗃️ Struktur Database

Jika database belum tersedia, buat struktur tabel berikut pada SQL Server-mu:

```sql
-- Tabel Department
CREATE TABLE department (
    dept_name VARCHAR(20) PRIMARY KEY,
    building VARCHAR(15),
    budget NUMERIC(12, 2)
);

-- Tabel Instructor
CREATE TABLE instructor (
    ID VARCHAR(5) PRIMARY KEY, -- Atau INT IDENTITY(1,1) jika ingin auto-increment
    name VARCHAR(20) NOT NULL,
    dept_name VARCHAR(20),
    salary NUMERIC(8, 2),
    CONSTRAINT FK_dept_name FOREIGN KEY (dept_name) REFERENCES department(dept_name)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);
```

---

## 🛠 Teknologi yang Digunakan

- Java
- JDBC
- JasperReports
- SQL Server
