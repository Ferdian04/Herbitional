const connection = require("../mysql/connect");

exports.specificdis = async (req, res) => {
  try {
    const id_penyakit = req.params.id_penyakit;
    console.log(id_penyakit);
    let db = `
      SELECT * FROM tabel_penyakit WHERE id_penyakit = ${id_penyakit}
        `;
    connection.query(db, function (err, data) {
      if ((data = [])) {
        return res.status(404).json({
          status: "Failed",
          requestAt: new Date().toISOString(),
          message: "Not Found",
        });
      }
      return res.status(201).json({
        status: "Success",
        requestAt: new Date().toISOString(),
        artikel: data,
      });
    });
  } catch (err) {
    return res.status(err.code).json({
      status: "Failed",
      message: err.message,
    });
  }
};
