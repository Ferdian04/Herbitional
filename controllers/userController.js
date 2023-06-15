const connection = require("../mysql/connect");

exports.profile = async (req, res) => {
  try {
    console.log("Profile .....");
    const { jwt } = req;
    console.log(jwt.user_id);
    db = `
    SELECT tabel_riwayat_user.id_riwayat, tabel_penyakit.id_penyakit, tabel_penyakit.nama_penyakit
    FROM tabel_riwayat_user
    JOIN tabel_penyakit ON tabel_riwayat_user.penyakit_id = tabel_penyakit.id_penyakit
    WHERE tabel_riwayat_user.user_id = "${jwt.user_id}"
    `;

    db1 = `SELECT fullname, user_email FROM user_login WHERE user_id = ${jwt.user_id}`;

    connection.query(db, function (err, data) {
      connection.query(db1, function (err, data1) {
        const fullname = data1[0].fullname;
        const user_email = data1[0].user_email;
        return res.status(201).json({
          status: "Success",
          requestAt: new Date().toISOString(),
          fullname: fullname,
          user_email: user_email,
          riwayat: data,
        });
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
    let { user_id, penyakit_id } = req.body;
    let ins_db = `INSERT INTO tabel_riwayat_user (user_id, penyakit_id) VALUES ('${user_id}','${penyakit_id}');`;
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
