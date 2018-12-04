package com.github.draylar;

import com.github.draylar.view.views.list.SongListView;
import com.github.draylar.view.views.song.SongView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application
{
    private static SongListView songList = new SongListView(new File("your_music_path_here"));
    private static Stage stage;

    @Override
    public void start(Stage primaryStage)
    {
        stage = primaryStage;
        stage.setScene(new Scene(songList, 800, 600));
        stage.show();
    }


    /**
     * Called when a song name is clicked on in the song list view. Changes the scene to a song with visualizer.
     */
    public static void songClicked(File file)
    {
        stage.setScene(new Scene(new SongView(file), 800, 600));
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
