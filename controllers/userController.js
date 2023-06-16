const connection = require("../mysql/connect");

exports.profile = async (req, res) => {
  try {
    console.log("Profile .....");
    const { jwt } = req;

    db = `
    SELECT tabel_riwayat_user.id_riwayat, tabel_penyakit.id_penyakit, tabel_penyakit.nama_penyakit
    FROM tabel_riwayat_user
    JOIN tabel_penyakit ON tabel_riwayat_user.penyakit_id = tabel_penyakit.id_penyakit
    WHERE tabel_riwayat_user.user_id = "${jwt.user_id}"
    `;

    connection.query(db, function (err, data) {
      const fullname = jwt.fullname;
      const user_email = jwt.user_email_address;
      return res.status(201).json({
        status: "Success",
        requestAt: new Date().toISOString(),
        fullname: fullname,
        user_email: user_email,
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

exports.inshistori = async (req, res) => {
  try {
    console.log("Input .....");
    let { penyakit_id } = req.body;
    const { jwt } = req;
    console.log(jwt.user_id);
    let ins_db = `INSERT INTO tabel_riwayat_user (user_id, penyakit_id) VALUES ('${jwt.user_id}','${penyakit_id}');`;
    connection.query(ins_db, function (err, data) {
      return res.status(201).json({
        status: "Success",
        requestAt: new Date().toISOString(),
      });
    });
  } catch (err) {
    return res.status(err.code).json({
      status: "Failed",
      message: err.message,
    });
  }
};
