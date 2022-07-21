//==================================================================================================================== 1
open class TokoBukuAND() {
    // Deklarasi buku dan harganya ---------------------------------
    val daftar_buku = arrayOf<String>(
        "Kumpulan Project Android Kotlin",
        "Dasar Bahasa Pemrograman Kotlin",
        "Mekanika Kuantum Edisi 5 Jilid 2",
        "Kumpulan Resep Masakan Indonesia"
    )
    val harga_buku = arrayOf<Int>(80000,70000,85000,90000)

    // Method ------------------------------------------------------
    // Menampilkan menu buku
    open fun penjualan() {
        println("================================")
        println("         TOKO BUKU AND5")
        println("--------------------------------\n")
        println("Buku yang tersedia saat ini:")
    }

    // Menghitung total harga
    private fun total_harga(nomor_buku : Int, jml_buku : Int) : Int {
        var total = harga_buku[nomor_buku-1]*jml_buku

        if (total > 300000) {
            total = total - bonus(total).toString().toInt()
        }
        return total
    }

    //================================================================================================================ 2
    // Kalkulasi transaksi (mencari jumlah kembalian)
    private fun transaksi(nomor_buku : Int, jml_buku : Int, jml_pembayaran : Int) : Int {
        return jml_pembayaran - total_harga(nomor_buku, jml_buku)
    }

    // Menampilkan struk pembelian
    internal fun invoice(nama_pembeli : String, nomor_buku: Int, jml_buku: Int) {
        println("\n-------------------------------")
        println("    INVOICE PEMBELIAN BUKU")
        println("-------------------------------\n")

        println("Nama pembeli : ${nama_pembeli.uppercase()}")
        println("Judul buku   : ${daftar_buku[nomor_buku-1]}")
        println("Jumlah       : $jml_buku")
        println("Harga        : Rp ${total_harga(nomor_buku, jml_buku)}")
    }

    //================================================================================================================ 3
    // Menampilkan struk pembelian
    internal fun struk(nama_pembeli: String, nomor_buku: Int, jml_buku: Int, jml_pembayaran: Int) {
        println("\n================================")
        println(" STRUK PEMBELIAN BUKU TOKO AND5")
        println("--------------------------------\n")
        println("Nama pembeli   : ${nama_pembeli.uppercase()}")
        println("Buku yg dibeli : ${daftar_buku[nomor_buku-1]}")
        println("Jumlah         : $jml_buku")
        println("Total          : Rp ${total_harga(nomor_buku, jml_buku)}")
        println("Bayar          : Rp $jml_pembayaran")
        println("Kembali        : Rp ${transaksi(nomor_buku, jml_buku, jml_pembayaran)}")
        println("Bonus          : ${bonus(harga_buku[nomor_buku-1]*jml_buku)}")

        println("\n---------- TERIMAKASIH ---------")
        println("         TOKO BUKU AND5")
        println("================================")
    }

    // Penentuan bonus
    private fun bonus(total_belanja : Int) : Any{
        val bonusnya : Any

        if (total_belanja > 150000 && total_belanja <= 200000) {
            bonusnya = "1 buah pena kecil"
        } else if (total_belanja > 200000 && total_belanja <= 300000) {
            bonusnya = "1 buah buku catatan"
        } else if (total_belanja > 300000) {
            bonusnya = 50000
        } else {
            bonusnya = 0
        }

        return bonusnya
    }
}

//==================================================================================================================== 4
class Buku() : TokoBukuAND() {
    // Method ------------------------------------------------------
    override fun penjualan() {
        super.penjualan()

        for (i in 0 .. daftar_buku.size-1) {
            print("${i + 1}. ${daftar_buku[i]}\t\t")    // Memunculkan daftar buku
            println("Rp ${harga_buku[i]}")              // Memunculkan harga buku
        }
    }
}

fun main() {
    /* ------------------------------------------------------
    * Menampilkan daftar buku dan input pembeli
    * ------------------------------------------------------*/

    Buku().penjualan()

    print("\nPilih nomor buku yang akan dibeli\t\t: ")
    val nomor_buku = readLine()!!.toInt()

    print("Jumlah buku yang akan dibeli\t\t\t: ")
    val jml_buku = readLine()!!.toInt()

    print("Tulis nama anda untuk bukti pembelian\t: ")
    val nama_pembeli = readLine().toString()

    /* ------------------------------------------------------
    * Menampilkan invoice dan input pembayaran
    * ------------------------------------------------------*/

    TokoBukuAND().invoice(nama_pembeli, nomor_buku, jml_buku)
    print("\nMasukkan jumlah pembayaran : Rp ")
    val jml_pembayaran = readLine()!!.toInt()

    /* ------------------------------------------------------
    * Menampilkan struk pembelian
    * ------------------------------------------------------*/

    TokoBukuAND().struk(nama_pembeli, nomor_buku, jml_buku, jml_pembayaran)

    // End --------------------------------------------------
}