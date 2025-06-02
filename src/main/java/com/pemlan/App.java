package com.pemlan;

import com.pemlan.controller.MainController;
import com.pemlan.db.DatabaseConnection;
import com.pemlan.model.DepartmentDAO;
import com.pemlan.model.InstructorDAO;
import com.pemlan.view.MainFrame;

import javax.swing.*;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection.getConnection();
            System.out.println("Koneksi database berhasil!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal terhubung ke database: " + e.getMessage() +
                            "\nPastikan SQL Server berjalan dan konfigurasi sudah benar.",
                    "Database Connection Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            InstructorDAO instructorDAO = new InstructorDAO();
            DepartmentDAO departmentDAO = new DepartmentDAO();
            new MainController(mainFrame, instructorDAO, departmentDAO);
        });

        Runtime.getRuntime().addShutdownHook(new Thread(DatabaseConnection::closeConnection));
    }
}