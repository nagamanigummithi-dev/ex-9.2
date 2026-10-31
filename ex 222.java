String query =
    "INSERT INTO users (name, email) VALUES (?, ?)";

PreparedStatement pst = con.prepareStatement(query);

pst.setString(1, "John Doe");
pst.setString(2, "john@example.com");

pst.executeUpdate();
