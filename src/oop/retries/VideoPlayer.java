package oop.retries;

public class VideoPlayer
{
    public static boolean playWithRetries(Video video, int versuch)
    {
        boolean played = false;
        if (versuch > 0)
        {
            if (video == null)
            {
                throw new NullPointerException("ung�ltige Video");
            }
            for (int i = 1; i <= versuch; i++)
            {
                try
                {
                    video.play();
                    played = true;
                }
                catch (OverloadException e)
                {
                    played = false;
                    continue;
                }
                if (played)
                {
                    break;
                }
            }
        }
        return played;

    }
}
