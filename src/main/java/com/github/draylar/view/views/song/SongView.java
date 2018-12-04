package com.github.draylar.view.views.song;

import com.github.draylar.visualizer.Visualizer;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class SongView extends GridPane
{
    private Label songName = new Label();
    private Visualizer visualizer;
    private Timer drawTimer = new Timer();

    public SongView(File file)
    {
        songName.setText(file.getName().substring(0, file.getName().indexOf(".")));
        visualizer = new Visualizer(file, 600, 800);

        setupGrid();
        addChildren();
        startMusic();
    }


    /**
     * Starts the music & visualizer in a timer that runs every 16 ms (~+60 FPS)
     */
    private void startMusic()
    {
        visualizer.start();

        // task runs every 16 ms. Platform.runLater() is used so the visualizer can use JavaFX components.
        TimerTask timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                Platform.runLater(() ->
                        visualizer.drawCurrentFrame());
            }
        };

        drawTimer.schedule(timerTask, 0, 16);
    }

    private void stopMusic()
    {
        visualizer.stop();
        drawTimer.cancel();
    }

    private void setupGrid()
    {
        for (int i = 0; i < 100; i++)
        {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(1);
            getColumnConstraints().add(columnConstraints);
        }

        for (int i = 0; i < 100; i++)
        {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(1);
            getRowConstraints().add(rowConstraints);
        }
    }

    private void addChildren()
    {
        this.add(visualizer, 20, 45);
        this.add(songName, 10, 80, 100, 10);
    }
}
