## Fitur

### 1. CounterApp
- Menampilkan jumlah saat ini dan dua tombol: "tambah" dan "kurang".
- State: `count` disimpan dengan `remember { mutableStateOf(0) }`.
- Increment: `count++`.
- Decrement: dicegah agar tidak kurang dari 0. Tombol "kurang" dinonaktifkan saat `count <= 0` untuk mencegah nilai negatif.

Behavior:
- Perubahan pada `count` memicu recomposition, sehingga teks dan status tombol diperbarui otomatis.

### 2. ToggleWarna
- Menampilkan kotak berbentuk lingkaran yang berganti warna antara Biru dan Merah.
- State: `isRed` menggunakan `remember { mutableStateOf(false) }`.
- Satu tombol "Toggle Warna" membalik `isRed`, yang merekomposisi warna latar `Box`.

Behavior:
- UI langsung mencerminkan perubahan state tanpa pemanggilan refresh manual.

### 3. ProfileCard
- Menampilkan foto profil, nama, peran, dan tombol Follow/Unfollow.
- State: `isFollowed` dilacak lokal dengan `remember { mutableStateOf(false) }`.
- Label tombol dan teks status berubah antara "Follow"/"Unfollow" beserta pesan terkait.

Behavior:
- Mengubah `isFollowed` merekomposisi `Text`/`Button`, menjaga sinkronisasi UI dan state.

## Mengapa Compose lebih sederhana daripada XML
- UI deklaratif berbasis state: UI adalah fungsi dari state; tidak perlu pembaruan view imperatif, wiring listener, atau `findViewById`.
- Lebih sedikit boilerplate: Layout, styling, dan interaksi berada dalam composable Kotlin yang ringkas alih\-alih terpisah antara XML \+ Kotlin.
- Komposabilitas dan reuse: Composable kecil \(`CounterApp`, `ToggleWarna`, `ProfileCard`\) mudah diuji dan digunakan ulang.
- Modifier menyatukan layout \+ styling \+ interaksi: Tidak perlu banyak atribut XML dan kelas view terpisah.
- Preview instan dan recomposition: Perubahan state secara otomatis me\-render ulang bagian yang terdampak tanpa invalidasi manual.
