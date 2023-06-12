const connection = require("../mysql/connect");

exports.specificmed = async (req, res) => {
  try {
    const id_artikel = req.params.id_artikel;
    console.log(id_artikel);
    let db = `
  SELECT * FROM tabel_artikel WHERE id = ${id_artikel}
    `;
    connection.query(db, function (err, data) {
      if ((data.length = [])) {
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

exports.home = async (req, res) => {
  try {
    console.log("Home .....");
    let db = `
    SELECT tabel_artikel.id, tabel_artikel.nama_obat, tabel_artikel.deskripsi, tabel_artikel.foto_obat FROM tabel_artikel ORDER BY RAND() LIMIT 5
      `;
    connection.query(db, function (err, data) {
      if (data.length <= 0) {
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

exports.searchmed = async (req, res) => {
  try {
    const searchmed = req.params.search;
    let db = `
    SELECT tabel_artikel.id, tabel_artikel.nama_obat, tabel_artikel.deskripsi, tabel_artikel.foto_obat FROM tabel_artikel WHERE nama_obat LIKE '%${searchmed}%' OR khasiat LIKE '%${searchmed}%' OR deskripsi LIKE '%${searchmed}%'
      `;
    console.log(searchmed);
    connection.query(db, function (err, data) {
      console.log(data);
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
