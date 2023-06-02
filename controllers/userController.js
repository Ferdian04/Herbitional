const connection = require("../mysql/connect");

exports.profile = async (req, res) => {
  try {
    console.log("Profile .....");
    const user_id = req.params.id;
    console.log(user_id);
    db = `
    SELECT tabel_riwayat_user.id_riwayat, tabel_penyakit.id_penyakit, tabel_penyakit.nama_penyakit FROM tabel_riwayat_user JOIN tabel_penyakit ON tabel_riwayat_user.penyakit_id = tabel_penyakit.id_penyakit
    WHERE tabel_riwayat_user.user_id = "${user_id}"
    `;

    connection.query(db, function (err, data) {
      return res.status(201).json({
        status: "Success",
        requestAt: new Date().toISOString(),
        riwayat: data,
      });
    });
  } catch (err) {
    return res.status(err.code).json({
      status: "Failed",
      message: err.message,
    });
  }
};
