const connection = require("../mysql/connect");

exports.getMed = async (req, res) => {
  console.log("Cari .....");
  let { tag } = req.body;

  let db = `
SELECT * FROM tabel_artikel WHERE artikel LIKE "%${tag}%"
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
      artikel: data,
      requestAt: new Date().toISOString(),
    });
  });
};

exports.specificmed = async (req, res) => {
  const id_artikel = req.params.id_artikel;
  let db = `
  SELECT * FROM tabel_artikel WHERE id LIKE "%${id_artikel}%"
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
      artikel: data,
      requestAt: new Date().toISOString(),
    });
  });
};

exports.home = async (req, res) => {
  console.log("Home .....");
  let db = `
SELECT * FROM tabel_artikel LIMIT 5
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
      artikel: data,
      requestAt: new Date().toISOString(),
    });
  });
};
