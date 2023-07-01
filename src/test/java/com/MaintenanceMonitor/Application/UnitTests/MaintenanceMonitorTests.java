package com.MaintenanceMonitor.Application.UnitTests;

import com.MaintenanceMonitor.Application.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MaintenanceMonitorTests {

    @Autowired
    private MessageService messageService;

    @Test
    public void testGetDefaultMessage() {
        // Arrange
        String defaultMessage = "Everything works as expected";

        // Act
        messageService.resetMessage();
        String getDefaultMM = messageService.getDefaultMessage();

        // Assert
        assertThat(getDefaultMM).isEqualTo(defaultMessage);
    }

    @Test
    public void testSetMessage() {
        // Arrange
        String mm = "Halil+und+Mehmet";

        // Act
        String mmWeb = messageService.setMessage(mm);

        // Assert
        assertThat(mmWeb).isEqualTo("ok");
        assertThat(messageService.getDefaultMessage()).isEqualTo("Halil und Mehmet");
    }

    @Test
    public void testGetFalseMessage() {
        // Arrange
        String fm = "You tried a false statement, the right one is Localhost:8080/api/message/set?m=Your Message";

        // Act
        String fmWeb = messageService.getFalseMessage();

        // Assert
        assertThat(fmWeb).isEqualTo(fm);
    }

    @Test
    public void testResetMessage() {
        // Arrange
        String mm = "Halil und Mehmet";

        // Act
        String mmWeb = messageService.setMessage("Halil+und+Mehmet");

        // Assert
        assertThat(messageService.getDefaultMessage()).isEqualTo(mm);

        // Arrange
        String rm = "Everything works as expected";

        // Act
        String rmWeb = messageService.resetMessage();

        // Assert
        assertThat(messageService.getDefaultMessage()).isEqualTo(rm);
    }
}