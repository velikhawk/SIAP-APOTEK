-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 20, 2023 at 04:32 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apotek_mulyo`
--

-- --------------------------------------------------------

--
-- Table structure for table `ms_barang`
--

CREATE TABLE `ms_barang` (
  `kode_obat` char(20) NOT NULL,
  `nama_obat` char(200) NOT NULL,
  `kode_jenis` char(11) NOT NULL,
  `tanggal_kadaluwarsa` date NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga_beli` int(11) NOT NULL,
  `harga_jual` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `ms_barang`
--

INSERT INTO `ms_barang` (`kode_obat`, `nama_obat`, `kode_jenis`, `tanggal_kadaluwarsa`, `jumlah`, `harga_beli`, `harga_jual`) VALUES
('ANT_KAP1', 'Antimo', 'KAP1', '2027-06-10', 53, 4000, 5000),
('ANT_S1', 'Antimo', 'S1', '2027-06-10', 50, 4000, 5000),
('BAL_OLS1', 'Balsem', 'OLS1', '2027-06-10', 50, 4000, 5000),
('INS_TTES1', 'Insto', 'TTES1', '2027-06-10', 49, 4000, 5000),
('KOM_CA1', 'Komix ubah', 'CA1', '2025-06-10', 45, 2000, 3000),
('MIXG_TAB1', 'Mixagrip', 'Tab1', '2027-06-10', 43, 4000, 5000);

-- --------------------------------------------------------

--
-- Table structure for table `ms_jenis`
--

CREATE TABLE `ms_jenis` (
  `kode_jenis` char(11) NOT NULL,
  `nama_jenis` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ms_jenis`
--

INSERT INTO `ms_jenis` (`kode_jenis`, `nama_jenis`) VALUES
('CA1', 'CAIR'),
('KAP1', 'Kapsul'),
('OLS1', 'Obat Oles'),
('SIR1', 'Sirup'),
('SUN1', 'Obat Suntik'),
('TAB1', 'Tablet'),
('TTES1', 'Obat Tetes');

-- --------------------------------------------------------

--
-- Table structure for table `ms_pbf`
--

CREATE TABLE `ms_pbf` (
  `kode_pbf` char(20) NOT NULL,
  `nama_pbf` char(200) NOT NULL,
  `alamat` text NOT NULL,
  `telepon` char(15) NOT NULL,
  `kota` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ms_pbf`
--

INSERT INTO `ms_pbf` (`kode_pbf`, `nama_pbf`, `alamat`, `telepon`, `kota`) VALUES
('PBF001', 'Sutejo Karlani', 'Banyuputih', '086213399824', 'Batang'),
('PBF002', 'Sumeno', 'Mangkang', '086213399725', 'Semarang'),
('PBF003', 'Caslani', 'Randudongkal', '0862133997289', 'Pemalang'),
('PBF01', 'bintang surya', 'manggis, tulis, batang', '085213399824', 'pekalongan');

-- --------------------------------------------------------

--
-- Table structure for table `ms_pelanggan`
--

CREATE TABLE `ms_pelanggan` (
  `kode_pelanggan` varchar(11) NOT NULL,
  `nama_pelanggan` varchar(30) NOT NULL,
  `alamat` text NOT NULL,
  `telepon` char(15) NOT NULL,
  `kota` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ms_pelanggan`
--

INSERT INTO `ms_pelanggan` (`kode_pelanggan`, `nama_pelanggan`, `alamat`, `telepon`, `kota`) VALUES
('KAR01', 'Karmani mani', 'Tulis batang jateng', '123565757', 'Batang'),
('KAY1', 'Kayem', 'Limpung', '123456', 'Batang'),
('NI1', 'Nia', 'Bawang', '12345678', 'Batang'),
('UM1', 'Umum', '-', '-', '-');

-- --------------------------------------------------------

--
-- Table structure for table `ms_pengguna`
--

CREATE TABLE `ms_pengguna` (
  `nama_pengguna` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `level` varchar(20) NOT NULL,
  `jenis_kelamin` enum('L','P') NOT NULL,
  `no_telpon` varchar(15) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ms_pengguna`
--

INSERT INTO `ms_pengguna` (`nama_pengguna`, `username`, `password`, `level`, `jenis_kelamin`, `no_telpon`, `alamat`) VALUES
('aa', 'velik', '123456789', 'APA', 'L', '12', 'aa'),
('w', 'velikkasir', '1234', 'Kasir', 'L', '12', 'w'),
('c', 'c', 'c', 'APA', 'L', 'c', 'c'),
('ve', 'velike', '123456789', 'APA', 'L', '123456', 'sdsa');

-- --------------------------------------------------------

--
-- Table structure for table `ms_perkiraan`
--

CREATE TABLE `ms_perkiraan` (
  `kode` char(20) NOT NULL,
  `nama` char(200) NOT NULL,
  `kelompok` int(1) NOT NULL,
  `tipe` enum('H','D') NOT NULL,
  `saldo_akhir` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `ms_perkiraan`
--

INSERT INTO `ms_perkiraan` (`kode`, `nama`, `kelompok`, `tipe`, `saldo_akhir`) VALUES
('1-0000', 'AKTIVA', 1, 'H', 0),
('1-1000', 'AKTIVA LANCAR', 1, 'H', 0),
('1-1100', 'KAS', 1, 'D', 0),
('1-1110', 'KAS OPERASIONAL', 1, 'D', 0),
('1-1120', 'KAS KECIL', 1, 'D', 0),
('1-1130', 'BANK', 1, 'D', 0),
('1-1131', 'BANK BCA', 1, 'D', 0),
('1-1132', 'BANK MANDIRI', 1, 'D', 0),
('1-1133', 'BANK BNI', 1, 'D', 0),
('1-1160', 'KAS BELUM DISETOR', 1, 'D', 0),
('1-1200', 'PIUTANG', 1, 'H', 0),
('1-1210', 'PIUTANG DAGANG', 1, 'D', 0),
('1-1211', 'PIUTANG KARTU KREDIT', 1, 'D', 0),
('1-1220', 'PIUTANG KARYAWAN', 1, 'D', 0),
('1-1300', 'PERSEDIAAN', 1, 'H', 0),
('1-1310', 'PERSEDIAAN BARANG DAGANGAN', 1, 'D', 0),
('1-1400', 'BIAYA DIBAYAR DIMUKA', 1, 'H', 0),
('1-1410', 'PENGELUARAN DIBAYAR DIMUKA', 1, 'D', 0),
('1-1420', 'SEWA DIBAYAR DIMUKA', 1, 'D', 0),
('1-1430', 'ASURANSI DIBAYAR DIMUKA', 1, 'D', 0),
('1-1500', 'PAJAK', 1, 'H', 0),
('1-1510', 'PAJAK MASUKAN', 1, 'D', 0),
('1-1511', 'PAJAK MASUKAN BELUM DITERIMA', 1, 'D', 0),
('1-1520', 'PAJAK DIBAYAR DIMUKA LAINNYA', 1, 'D', 0),
('1-2000', 'AKTIVA TETAP', 1, 'H', 0),
('1-2100', 'TANAH', 1, 'D', 0),
('1-2210', 'BANGUNAN / GEDUNG', 1, 'D', 0),
('1-2211', 'AKUM PENYUSUTAN GEDUNG', 1, 'D', 0),
('1-2310', 'KENDARAAN', 1, 'D', 0),
('1-2311', 'AKUN PENYUSUTAN KENDARAAN', 1, 'D', 0),
('1-2410', 'PERALATAN', 1, 'D', 0),
('1-2411', 'AKUM PENYUSUTAN PERALATAN', 1, 'D', 0),
('1-2500', 'INVESTASI', 1, 'H', 0),
('1-2510', 'DEPOSITO', 1, 'D', 0),
('1-2520', 'SAHAM', 1, 'D', 0),
('1-2530', 'INVESTASI LAINNYA', 1, 'D', 0),
('1-2800', 'ASET TIDAK BERWUJUD', 1, 'H', 0),
('1-2810', 'TRADEMARK / HAK MEREK', 1, 'D', 0),
('1-2811', 'GOODWILL', 1, 'D', 0),
('2-0000', 'KEWAJIBAN', 2, 'H', 0),
('2-1000', 'KEWAJIBAN LANCAR', 2, 'H', 0),
('2-1100', 'HUTANG OPERASIONAL', 2, 'H', 0),
('2-1110', 'HUTANG USAHA', 2, 'D', 0),
('2-1111', 'HUTANG KARTU KREDIT', 2, 'D', 0),
('2-1112', 'HUTANG KONSINYASI', 2, 'D', 0),
('2-1200', 'PENDAPATAN DITERIMA DIMUKA', 2, 'D', 0),
('2-1300', 'HUTANG PAJAK', 2, 'H', 0),
('2-1310', 'PAJAK KELUARAN', 2, 'D', 0),
('2-1311', 'PAJAK KELUARAN BELUM TERBIT', 2, 'D', 0),
('2-2000', 'KEWAJIBAN TIDAK LANCAR', 2, 'H', 0),
('2-2110', 'HUTANG BANK TIDAK LANCAR', 2, 'D', 0),
('2-2400', 'HUTANG GAJI', 2, 'H', 0),
('2-2410', 'HUTANG GAJI', 2, 'D', 0),
('2-2420', 'HUTANG PPH 21', 2, 'D', 0),
('2-2500', 'HUTANG BANK', 2, 'H', 0),
('2-2510', 'HUTANG BANK BCA', 2, 'D', 0),
('3-0000', 'MODAL', 3, 'H', 0),
('3-1000', 'MODAL USAHA', 3, 'D', 0),
('3-2000', 'MODAL SAHAM', 3, 'D', 0),
('3-3998', 'LABA DITAHAN S/D TAHUN LALU', 3, 'D', 0),
('3-3999', 'LABA DITAHAN TAHUN BERJALAN', 3, 'D', 0),
('3-9999', 'OPENING BALANCE', 3, 'D', 0),
('4-0000', 'PENDAPATAN', 4, 'H', 0),
('4-1000', 'PENDAPATAN DAGANG', 4, 'H', 0),
('4-1100', 'PENDAPATAN JUAL', 4, 'D', 0),
('4-1200', 'BIAYA PENJUALAN', 4, 'D', 0),
('4-1500', 'POTONGAN JUAL', 4, 'D', 0),
('4-1600', 'RETUR JUAL', 4, 'D', 0),
('4-2000', 'PENDAPATAN JASA', 4, 'D', 0),
('5-0000', 'HPP', 5, 'H', 0),
('5-1000', 'HARGA POKOK PENJUALAN', 5, 'D', 0),
('5-2200', 'PENGATURAN STOK', 5, 'D', 0),
('6-0000', 'BIAYA', 6, 'H', 0),
('6-1000', 'BIAYA UMUM', 6, 'H', 0),
('6-1010', 'BIAYA GAJI STAF HARIAN', 6, 'D', 0),
('6-1100', 'BIAYA LISTRIK/AIR/TELP', 6, 'D', 0),
('6-1200', 'BIAYA BUNGA PINJAMAN', 6, 'D', 0),
('6-1300', 'BIAYA ASURANSI', 6, 'D', 0),
('6-1400', 'BIAYA ATK', 6, 'D', 0),
('6-1500', 'PERLENGKAPAN KANTOR', 6, 'D', 0),
('6-1600', 'POTONGAN TUNAI', 6, 'D', 0),
('6-1700', 'ONGKOS ANGKUT PEMBELIAN', 6, 'D', 0),
('6-1800', 'BIAYA DENDA', 6, 'D', 0),
('6-1900', 'BIAYA SEWA', 6, 'D', 0),
('6-2000', 'BIAYA PEMASARAN', 6, 'H', 0),
('6-2100', 'BIAYA IKLAN', 6, 'D', 0),
('6-2200', 'BIAYA PROMOSI', 6, 'D', 0),
('6-3000', 'BIAYA OPERASIONAL', 6, 'H', 0),
('6-3100', 'BIAYA KIRIM', 6, 'D', 0),
('6-3110', 'BIAYA CETAK', 6, 'D', 0),
('6-3200', 'BIAYA SEWA KENDARAAN', 6, 'D', 0),
('6-3300', 'BIAYA PERAWATAN KENDARAAN', 6, 'D', 0),
('6-4000', 'BIAYA GAJI DAN UPAH', 6, 'H', 0),
('6-4100', 'BIAYA GAJI DAN UPAH KARYAWAN', 6, 'D', 0),
('6-4200', 'BIAYA GAJI DAN UPAH LAINNYA', 6, 'D', 0),
('6-5000', 'BIAYA PENYUSUTAN', 6, 'H', 0),
('6-5100', 'PENYUSUTAN', 6, 'D', 0),
('7-0000', 'PENDAPATAN LAIN', 7, 'H', 0),
('7-1100', 'BUNGA', 7, 'D', 0),
('7-1110', 'PENDAPATAN BUNGA DEPOSITO', 7, 'D', 0),
('7-1120', 'PENDAPATAN DEVIDEN SAHAM', 7, 'D', 0),
('8-0000', 'BIAYA LAIN', 8, 'H', 0),
('8-1000', 'BEBAN BUNGA', 8, 'D', 0),
('8-2000', 'BIAYA PAJAK PENGHSILAN', 8, 'D', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tr_jurnal_transaksi`
--

CREATE TABLE `tr_jurnal_transaksi` (
  `id` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `nomor_bukti` char(20) NOT NULL,
  `keterangan` char(200) NOT NULL,
  `kode_rekening` char(20) NOT NULL,
  `tipe` char(20) NOT NULL,
  `debet` int(11) NOT NULL,
  `kredit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tr_jurnal_transaksi`
--

INSERT INTO `tr_jurnal_transaksi` (`id`, `tanggal`, `nomor_bukti`, `keterangan`, `kode_rekening`, `tipe`, `debet`, `kredit`) VALUES
(6, '2023-03-16', 'JKM000001', 'Pelunasan piutang', '1-1100', 'JKM', 50000000, 0),
(7, '2023-03-16', 'JKM000001', 'Pelunasan piutang', '1-1210', 'JKM', 0, 50000000),
(8, '2023-03-16', 'JKM000002', 'Penjualan peralatan tidak terpakai', '1-1100', 'JKM', 800000, 0),
(9, '2023-03-16', 'JKM000002', 'Penjualan peralatan tidak terpakai', '1-2410', 'JKM', 0, 500000),
(10, '2023-03-16', 'JKM000002', 'Penjualan peralatan tidak terpakai', '6-1500', 'JKM', 0, 300000),
(11, '2023-03-16', 'JKM000003', 'Penjualan perlengkapan kantor rusak', '1-1100', 'JKM', 700000, 0),
(12, '2023-03-16', 'JKM000003', 'Penjualan perlengkapan kantor rusak', '6-1500', 'JKM', 0, 700000),
(13, '2023-03-16', 'JKK000001', 'Pembayaran listrik Februari', '1-1100', 'JKM', 6000000, 0),
(14, '2023-03-16', 'JKK000001', 'Pembayaran listrik Februari', '6-1100', 'JKM', 0, 6000000),
(16, '2023-07-14', 'JJ000004', '', '', 'JKM', 5000, 0),
(17, '2023-07-14', 'JJ000004', 'INS_TTES1', 'TTES1', 'JKM', 0, 5000),
(24, '2023-07-14', 'JJ000005', 'UM1', 'UM1', 'JKM', 3000, 0),
(25, '2023-07-14', 'JJ000005', 'KOM_CA1', 'CA1', 'JKM', 0, 3000),
(26, '2023-07-14', 'JJ000006', 'Penjualan', '', 'JKM', 3000, 0),
(27, '2023-07-14', 'JJ000006', 'KOM_CA1', 'CA1', 'JKM', 0, 3000),
(28, '2023-07-14', 'RE001', 'Return Pembelian', '1-1100', 'JKM', 24000, 0),
(29, '2023-07-14', 'RE001', 'Return Pembelian', '1-1100', 'JKM', 0, 24000),
(30, '2023-07-14', 'JJ000007', 'Penjualan', '1-1100', 'JKM', 3000, 0),
(31, '2023-07-14', 'JJ000007', 'Penjualan', '1-1100', 'JKM', 0, 3000),
(32, '2023-07-16', 'JJ000008', 'Penjualan', '1-1100', 'JKM', 6000, 0),
(33, '2023-07-16', 'JJ000008', 'Penjualan', '1-1100', 'JKM', 0, 6000);

-- --------------------------------------------------------

--
-- Table structure for table `tr_kas_keluar`
--

CREATE TABLE `tr_kas_keluar` (
  `nomor` char(20) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` char(200) NOT NULL,
  `kode_rekening_kas` char(20) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tr_kas_keluar`
--

INSERT INTO `tr_kas_keluar` (`nomor`, `tanggal`, `keterangan`, `kode_rekening_kas`, `total`) VALUES
('JKK000001', '2023-03-16', 'Pembayaran listrik Februari', '1-1100', 6000000);

-- --------------------------------------------------------

--
-- Table structure for table `tr_kas_keluar_detail`
--

CREATE TABLE `tr_kas_keluar_detail` (
  `id` int(11) NOT NULL,
  `kode_rekening` char(20) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `header_nomor` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tr_kas_keluar_detail`
--

INSERT INTO `tr_kas_keluar_detail` (`id`, `kode_rekening`, `jumlah`, `header_nomor`) VALUES
(1, '6-1100', 6000000, 'JKK000001');

-- --------------------------------------------------------

--
-- Table structure for table `tr_kas_masuk`
--

CREATE TABLE `tr_kas_masuk` (
  `nomor` char(20) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` char(200) NOT NULL,
  `kode_rekening_kas` char(20) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tr_kas_masuk`
--

INSERT INTO `tr_kas_masuk` (`nomor`, `tanggal`, `keterangan`, `kode_rekening_kas`, `total`) VALUES
('JKM000001', '2023-03-16', 'Pelunasan piutang', '1-1100', 50000000),
('JKM000002', '2023-03-16', 'Penjualan peralatan tidak terpakai', '1-1100', 800000),
('JKM000003', '2023-03-16', 'Penjualan perlengkapan kantor rusak', '1-1100', 700000);

-- --------------------------------------------------------

--
-- Table structure for table `tr_kas_masuk_detail`
--

CREATE TABLE `tr_kas_masuk_detail` (
  `id` int(11) NOT NULL,
  `kode_rekening` char(20) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `header_nomor` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tr_kas_masuk_detail`
--

INSERT INTO `tr_kas_masuk_detail` (`id`, `kode_rekening`, `jumlah`, `header_nomor`) VALUES
(1, '1-1210', 50000000, 'JKM000001'),
(2, '1-2410', 500000, 'JKM000002'),
(3, '6-1500', 300000, 'JKM000002'),
(4, '6-1500', 700000, 'JKM000003');

-- --------------------------------------------------------

--
-- Table structure for table `tr_mutasi_obat`
--

CREATE TABLE `tr_mutasi_obat` (
  `id` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `nomor_bukti` char(20) NOT NULL,
  `keterangan` char(200) NOT NULL,
  `kode_obat` char(20) NOT NULL,
  `masuk_kuantiti` int(11) NOT NULL,
  `masuk_jumlah` int(11) NOT NULL,
  `keluar_kuantiti` int(11) NOT NULL,
  `keluar_jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tr_mutasi_obat`
--

INSERT INTO `tr_mutasi_obat` (`id`, `tanggal`, `nomor_bukti`, `keterangan`, `kode_obat`, `masuk_kuantiti`, `masuk_jumlah`, `keluar_kuantiti`, `keluar_jumlah`) VALUES
(1, '2023-07-14', 'JJ000005', 'UM1', 'KOM_CA1', 0, 0, 1, 3000),
(2, '2023-07-14', 'JJ000006', '', 'KOM_CA1', 0, 0, 1, 3000),
(3, '2023-07-14', 'RE001', 'Return Pembelian', 'MIXG_TAB1', 6, 24000, 0, 0),
(4, '2023-07-14', 'JJ000007', 'Penjualan', 'KOM_CA1', 0, 0, 1, 3000),
(5, '2023-07-16', 'JJ000008', 'Penjualan', 'KOM_CA1', 0, 0, 2, 6000);

-- --------------------------------------------------------

--
-- Table structure for table `tr_pembelian`
--

CREATE TABLE `tr_pembelian` (
  `nofaktur` char(20) NOT NULL,
  `tanggal` date NOT NULL,
  `kode_pbf` char(20) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tr_pembelian`
--

INSERT INTO `tr_pembelian` (`nofaktur`, `tanggal`, `kode_pbf`, `total`) VALUES
('a1', '2023-07-06', 'PBF001', 32000),
('a5', '2023-07-10', 'PBF003', 4000);

-- --------------------------------------------------------

--
-- Table structure for table `tr_pembelian_detail`
--

CREATE TABLE `tr_pembelian_detail` (
  `id` int(11) NOT NULL,
  `kode_obat` char(20) NOT NULL,
  `kuantiti` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `exp_date` date NOT NULL,
  `header_nofaktur` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tr_pembelian_detail`
--

INSERT INTO `tr_pembelian_detail` (`id`, `kode_obat`, `kuantiti`, `harga`, `jumlah`, `exp_date`, `header_nofaktur`) VALUES
(1, 'ANT_KAP1', 8, 4000, 32000, '2023-07-06', 'a1'),
(2, 'MIXG_TAB1', 1, 4000, 4000, '2023-07-10', 'a5');

--
-- Triggers `tr_pembelian_detail`
--
DELIMITER $$
CREATE TRIGGER `pembelian_obat` AFTER INSERT ON `tr_pembelian_detail` FOR EACH ROW BEGIN
UPDATE ms_barang SET jumlah = jumlah + new.kuantiti
WHERE kode_obat = new.kode_obat;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tr_penjualan`
--

CREATE TABLE `tr_penjualan` (
  `nomor` char(20) NOT NULL,
  `kode_pelanggan` varchar(11) NOT NULL,
  `tanggal` date NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tr_penjualan`
--

INSERT INTO `tr_penjualan` (`nomor`, `kode_pelanggan`, `tanggal`, `total`) VALUES
('JJ000001', 'KAY1', '2023-07-06', 5000),
('JJ000002', 'KAY1', '2023-07-10', 5000),
('JJ000003', 'KAR01', '2023-07-14', 5000),
('JJ000004', '', '2023-07-14', 5000),
('JJ000005', 'UM1', '2023-07-14', 3000),
('JJ000006', '', '2023-07-14', 3000),
('JJ000007', 'KAR01', '2023-07-14', 3000),
('JJ000008', '', '2023-07-16', 6000);

-- --------------------------------------------------------

--
-- Table structure for table `tr_penjualan_detail`
--

CREATE TABLE `tr_penjualan_detail` (
  `id` int(11) NOT NULL,
  `kode_obat` char(20) NOT NULL,
  `kode_jenis` varchar(11) NOT NULL,
  `kuantiti` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `header_nomor` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tr_penjualan_detail`
--

INSERT INTO `tr_penjualan_detail` (`id`, `kode_obat`, `kode_jenis`, `kuantiti`, `harga`, `jumlah`, `header_nomor`) VALUES
(1, 'ANT_KAP1', 'KAP1', 1, 5000, 5000, 'JJ000001'),
(2, 'MIXG_TAB1', 'TAB1', 1, 5000, 5000, 'JJ000002'),
(3, 'MIXG_TAB1', 'TAB1', 1, 5000, 5000, 'JJ000003'),
(5, 'INS_TTES1', 'TTES1', 1, 5000, 5000, 'JJ000004'),
(9, 'KOM_CA1', 'CA1', 1, 3000, 3000, 'JJ000005'),
(10, 'KOM_CA1', 'CA1', 1, 3000, 3000, 'JJ000006'),
(11, 'KOM_CA1', 'CA1', 1, 3000, 3000, 'JJ000007'),
(12, 'KOM_CA1', 'SIR1', 2, 3000, 6000, 'JJ000008');

--
-- Triggers `tr_penjualan_detail`
--
DELIMITER $$
CREATE TRIGGER `penjualan_obat` AFTER INSERT ON `tr_penjualan_detail` FOR EACH ROW BEGIN
UPDATE ms_barang SET jumlah = jumlah - new.kuantiti
WHERE kode_obat = new.kode_obat;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tr_return`
--

CREATE TABLE `tr_return` (
  `nomor` char(20) NOT NULL,
  `tanggal_return` date NOT NULL,
  `kode_pbf` char(20) NOT NULL,
  `nofaktur` char(20) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tr_return`
--

INSERT INTO `tr_return` (`nomor`, `tanggal_return`, `kode_pbf`, `nofaktur`, `total`) VALUES
('r1', '2023-07-06', 'PBF001', 'a1', 16000),
('RE001', '2023-07-14', 'PBF003', 'a5', 24000);

-- --------------------------------------------------------

--
-- Table structure for table `tr_return_detail`
--

CREATE TABLE `tr_return_detail` (
  `id` int(11) NOT NULL,
  `kode_obat` char(50) NOT NULL,
  `harga` int(11) NOT NULL,
  `kuantiti` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `header_nomor` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tr_return_detail`
--

INSERT INTO `tr_return_detail` (`id`, `kode_obat`, `harga`, `kuantiti`, `jumlah`, `header_nomor`) VALUES
(1, 'ANT_KAP1', 4000, 4, 16000, 'r1'),
(2, 'MIXG_TAB1', 4000, 6, 24000, 'RE001');

--
-- Triggers `tr_return_detail`
--
DELIMITER $$
CREATE TRIGGER `return_obat` AFTER INSERT ON `tr_return_detail` FOR EACH ROW BEGIN
UPDATE ms_barang SET jumlah = jumlah - new.kuantiti
WHERE kode_obat = new.kode_obat;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ms_barang`
--
ALTER TABLE `ms_barang`
  ADD PRIMARY KEY (`kode_obat`);

--
-- Indexes for table `ms_jenis`
--
ALTER TABLE `ms_jenis`
  ADD PRIMARY KEY (`kode_jenis`);

--
-- Indexes for table `ms_pbf`
--
ALTER TABLE `ms_pbf`
  ADD PRIMARY KEY (`kode_pbf`);

--
-- Indexes for table `ms_pelanggan`
--
ALTER TABLE `ms_pelanggan`
  ADD PRIMARY KEY (`kode_pelanggan`);

--
-- Indexes for table `ms_perkiraan`
--
ALTER TABLE `ms_perkiraan`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `tr_jurnal_transaksi`
--
ALTER TABLE `tr_jurnal_transaksi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tr_kas_keluar`
--
ALTER TABLE `tr_kas_keluar`
  ADD PRIMARY KEY (`nomor`);

--
-- Indexes for table `tr_kas_keluar_detail`
--
ALTER TABLE `tr_kas_keluar_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tr_kas_masuk`
--
ALTER TABLE `tr_kas_masuk`
  ADD PRIMARY KEY (`nomor`);

--
-- Indexes for table `tr_kas_masuk_detail`
--
ALTER TABLE `tr_kas_masuk_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tr_mutasi_obat`
--
ALTER TABLE `tr_mutasi_obat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tr_pembelian`
--
ALTER TABLE `tr_pembelian`
  ADD PRIMARY KEY (`nofaktur`);

--
-- Indexes for table `tr_pembelian_detail`
--
ALTER TABLE `tr_pembelian_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tr_penjualan`
--
ALTER TABLE `tr_penjualan`
  ADD PRIMARY KEY (`nomor`);

--
-- Indexes for table `tr_penjualan_detail`
--
ALTER TABLE `tr_penjualan_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tr_return`
--
ALTER TABLE `tr_return`
  ADD PRIMARY KEY (`nomor`);

--
-- Indexes for table `tr_return_detail`
--
ALTER TABLE `tr_return_detail`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tr_jurnal_transaksi`
--
ALTER TABLE `tr_jurnal_transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `tr_kas_keluar_detail`
--
ALTER TABLE `tr_kas_keluar_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tr_kas_masuk_detail`
--
ALTER TABLE `tr_kas_masuk_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tr_mutasi_obat`
--
ALTER TABLE `tr_mutasi_obat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tr_pembelian_detail`
--
ALTER TABLE `tr_pembelian_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tr_penjualan_detail`
--
ALTER TABLE `tr_penjualan_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tr_return_detail`
--
ALTER TABLE `tr_return_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
