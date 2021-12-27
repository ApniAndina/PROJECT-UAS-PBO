# UAS PROJECT PBO
# D3 MI KELAS B ANGAKATAN 2020
# ANGGOTA KELOMPOK 3 DAN PEMBAGIAN TUGASNYA:
- APNI ANDINA
- 2007051001
  - TASK
    - Class rekeningDataModel
    - Class FormNasabahController
    - Class dbHelper
    - Data Base sqlite
    - Class FormNasabah.fxml
    - Readme.md
      
- INTAN SOFIATUN NISYA
- 2007051015
  - TASK
    - Class Nasabah
    - Class Individu
    - Class Perusahaan
    - Class Structure

- HANIFA MUSLIMAH
- 2007051046
  - TASK
    - Class Rekening
    - Class UAS PROJECT PBO
    - ER Diagram

# CLASS STRUCTURE
 
     classDiagram
       Nasabah "1"--o"*" Rekening : has
       Nasabah <|-- Individu
       Nasabah <|-- Perusahaan

      class Nasabah{
          <<abstract>>
          -String nama 
          -String alamat 
          +Nasabah(nama, alamat ,rekening)
          +tambahRekening(Rekening rek)

          +abstract print()
      }
      class Individu{
          -long nik
          -long npwp
          +Individu(nik, npwp, alamat, rekening)
          + print()
      }
      class Rekening{
          -int noRekening
          -double saldo
          +Rekening(noRekening, saldo)
          +tambahSaldo(Double jumlah)
          +tarikTunai(Double jumlah)
      }
      class Perusahaan{
          -String nib
          +Perusahaan(nib, nama, alamat , rekening)
          +print()
      
      }
  
# ER DIAGRAM

        erDiagram
          Nasabah ||..|| individu : is
          Nasabah ||--|| Perusahaan : is
          Nasabah ||--|{ Rekening: "has"
          Nasabah {
            int Rekeningid
            string nama
            string alamat

          }
          individu{
            long nik
            long npwp
          }
          Perusahaan{
            string nib
          }
          Rekening{
            int noRekening
            double saldo
          }
          
# DESKRIPSI PROGRAM
Program ini dapat digunakan untuk melakukan transaksi tarik tunai, tambah saldo, pendaftaran rekening, penambahan rekening, perekaman atau penyimpanan data pemegang akun di suatu Sistem Koperasi, dimana terdapat 2 jenis akun yaitu akun individu dan akun perusahaan. Setiap Pemegang Akun dapat memiliki 1 akun atau lebih.
