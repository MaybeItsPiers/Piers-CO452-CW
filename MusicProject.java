import java.util.ArrayList;
import helpers.InputReader;


//Hello proffessor! I'll just quickly talk about how this program is put together for you.
//I've obviously started with importing a few things above,
//then I have written methods to initialise the lists that are manipulated everywhere else in the program.
//There's three lists: songTitles, artistNames, and playCounts.

//After writing those methods, the lists are initialised, and then the methods for manipulating them are written.
//The method most called is probably mainMenu, since it's in charge of calling all the rest from within a loop in MAIN.



public final class MusicProject
{
    //I'm just going to quickly define these lists here.
    //I used to have this code in the main function, but since I need some of the other methods 
    //to manipulate these lists, it works better to have it here
    ArrayList<String> songTitles = createSongTitles();
    ArrayList<String> artistNames = createArtistNames();
    ArrayList<Integer> playCounts = createPlayCounts();
    //I'm also going to define this boolean for future convenience.
    Boolean menuLeaveOption = false;
    
    
    
    public static void main(String[] args) 
    {
        


        System.out.println("==========================================");
        System.out.println("  CO452 Programming Concepts 2022/23");
        System.out.println("==========================================");
        System.out.println();
        System.out.println("       Course Work Project 1:");
        System.out.println("  Imitation Music Streaming Service");
        System.out.println("           by Piers Watson");
        System.out.println("==========================================");
        System.out.println();
        System.out.println();


        MusicProject runTime = new MusicProject();
        
        
        //All good programs start with a welcome message.
        System.out.println("Hello, and welcome to Maybe-Music");
        System.out.println("The only streaming service that doesnt let you actually listen to music!");
        
        //the vast majorety of the program will be done from within this loop.
        while (runTime.menuLeaveOption == false)
        {
            runTime.mainMenu();
        }

        //It's a little underwhelming, huh?
        //Ah well, time for a goodbye message

        System.out.println("Thank you for using Maybe-Music for all your database-query-ing needs!");

    }
    
    
    //This first method initialises the list of song titles
    public ArrayList<String> createSongTitles()
    {
        
        ArrayList<String> songTitlesTemp = new ArrayList<String>();
        songTitlesTemp.add("Angelfire");
        songTitlesTemp.add("Here Comes the Anxiety");
        songTitlesTemp.add("Unpopular");
        songTitlesTemp.add("Activator");
        songTitlesTemp.add("Always Yours");
        songTitlesTemp.add("Pigstep");
        songTitlesTemp.add("Cheetah Tongue");
        songTitlesTemp.add("the Glory Days");
        songTitlesTemp.add("Millionare");
        songTitlesTemp.add("Time Machine");

        return songTitlesTemp;
    }

    //This method initialises the list of artist names
    public ArrayList<String> createArtistNames()
    {
        ArrayList<String> artistNamesTemp = new ArrayList<String>();
        artistNamesTemp.add("Lemon Demon");
        artistNamesTemp.add("The Wombats");
        artistNamesTemp.add("Ugly Spy");
        artistNamesTemp.add("Morphadron");
        artistNamesTemp.add("SHE");
        artistNamesTemp.add("Lena Raine");
        artistNamesTemp.add("The Wombats");
        artistNamesTemp.add("Big Giant Circles");
        artistNamesTemp.add("Money Bags");
        artistNamesTemp.add("Waterflame");

        return artistNamesTemp;
    }

    // This method initialises the list of play counts. 
    // I used Integers to help with the arithmetic necessary for filtering by play count.
    // A float or double would be too much precision, since playcounts are always whole numbers.
    public ArrayList<Integer> createPlayCounts()
    {
        ArrayList<Integer> playCountsTemp = new ArrayList<Integer>();
        playCountsTemp.add(310440);
        playCountsTemp.add(91201);
        playCountsTemp.add(3);
        playCountsTemp.add(166563);
        playCountsTemp.add(17040);
        playCountsTemp.add(494591);
        playCountsTemp.add(164670);
        playCountsTemp.add(164750);
        playCountsTemp.add(1000001);
        playCountsTemp.add(8710155);

        return playCountsTemp;
    }

    /* 
    //I'm just going to quickly define these lists here.
    //I used to have this code in the main function, but since I need some of the other methods 
    //to manipulate these lists, it works better to have it here
    ArrayList<String> songTitles = createSongTitles();
    ArrayList<String> artistNames = createArtistNames();
    ArrayList<Integer> playCounts = createPlayCounts();
    //I'm also going to define this boolean for future convenience.
    Boolean menuLeaveOption = false;
    */

    //Now to make a few 'manipulation' methods
    public void addNewSong()
    {
        //This method will ask the user to input the info of a new song, then add it to the list.

        System.out.println("~~~~~~~~~~~~~");
        System.out.println("Please enter the Title of the song you would like to add to our database.");
        String newSongTitle = InputReader.getString("--> ");  
        System.out.println("Now please enter the name of the Artist(s) that created this song.");
        String newArtistName = InputReader.getString("--> ");
        System.out.println("And finally, please enter the current Play Count of this song.");
        System.out.println("In the event that the entered value is not a valid number, the program may come to a halt... so please don't do that");
        String newPlayCount = InputReader.getString("--> ");

        //Now to check if it IS a valid number
        Integer newCountInt = Integer.parseInt(newPlayCount);
        
        System.out.println("Processing...");
        songTitles.add(newSongTitle);
        artistNames.add(newArtistName);
        playCounts.add(newCountInt);

        System.out.println("New song info added! you will now be brought back to the main menu.");
    }
    
    //This method will ask the user what song they would like to remove, search the list for that song, 
    //and if there is a match then it will be removed. If not, back to the main menu.
    public void removeSong()
    {
        System.out.println("~~~~~~~~~~~~~");
        System.out.println("Please provide the name of the song you would like to remove from our database.");

        String badSong = InputReader.getString("--> ");

        
        System.out.println("Searching for " + badSong + "...");
            
        Integer badSongIndex = songTitles.lastIndexOf(badSong);

        if (badSongIndex != -1)
        {
            System.out.println("Song found: '" + songTitles.get(badSongIndex) + "' by '" + artistNames.get(badSongIndex) + "'.");
            System.out.println("Are you sure you would like to remove this from our database?");
            System.out.println("Enter 1 to proceed or 0 to cancel.");
            Integer areYouSure = InputReader.getInt("--> ");
            //I hope this 'areYouSure' thing is self explanitory enough.
            if (areYouSure == 1)
            {
                System.out.println("Deleting song...");
                    
                //I'm going to have to do something a little sneaky here.
                //I can't figure out how to remove an element at a specific index of the list, so instead
                //I'll convert that element to null, and remove all null values from the list.
                songTitles.set(badSongIndex, null);
                songTitles.remove(null);

                artistNames.set(badSongIndex, null);
                artistNames.remove(null);

                playCounts.set(badSongIndex, null);
                playCounts.remove(null);
                    
                System.out.println("Song deleted!");
            } 
            else if (areYouSure == 0)
            {
                System.out.println("Cancelling...");
            }
            else
            {
                System.out.println("Alright, smartypants, that wasn't really a valid answer, but I'll just assume you meant 0.");
            }
        } 
        else 
        {
            System.out.println("ERROR: matching song not found!");
        }
        

        System.out.println("Returning to main menu...");

    }
    //Wow, that one was a doosy
    

    //I have preserved below the original version of the 'playCountFilter' method.
    //Originally it had asked the user for the minimum play count, then searched in a loop.
    
    /*

    public void playCountFilter()
    {
        System.out.println("~~~~~~~~~~~~~");
        System.out.println("Please state the minimum number of plays you are searching for.");
        System.out.println("In the event that the entered value is not a valid number, the program may come to a halt... so please don't do that");
        Integer atLeastPlays = InputReader.getInt("--> ");

        //I'm also going to define this integer to count how many songs are above that minimum, 
        //so I can output an error message when the minimum is too high.
        Integer goodSongsCount = 0;

        System.out.println("Searching...");
        
        //This will loop for as many times as there are songs in the list
        for (Integer currentIndex = 0; currentIndex <= songTitles.size(); currentIndex++)
        {
            //Each time the current play count is above the inputted minimum, this will print out that song's info, and increase 'goodSongsCount'.
            if (playCounts.get(currentIndex) > atLeastPlays)
            {
                System.out.println(songTitles.get(currentIndex) + " by " + artistNames.get(currentIndex) + " has a play count of " + playCounts.get(currentIndex));
                goodSongsCount++;
            }
        }
        
        //Now for that error message I mentioned
        if (goodSongsCount == 0)
        {
            System.out.println("Sorry, there are no songs in our database that are quite that popular.");
        }
    }
    
    */

    //I'm going to rewrite it later so that it will recieve the minimum play count as a parameter.
    //That way, if someone wants a full list of all the songs, then I'll just run the same method with a parameter of 0!

    //But, first, I gotta write the main menu method.
    //This method will be responsible for calling all the other methods, so it's pretty important.
    //The idea is the main method will have a while loop for as long as the user wants to stay in the program, 
    //and this mainMenu method will run each loop.
    public void mainMenu()
    {
        System.out.println("~~~~~~~~~~~~~");
        System.out.println("Enter 1 to get a list of all songs in our database.");
        System.out.println("Enter 2 to filter for all songs above a certain play count.");
        System.out.println("Enter 3 to add a new song to our database.");
        System.out.println("Enter 4 to remove a song from our database.");
        System.out.println("Enter 5 to exit the program.");
        Integer menuSelect = InputReader.getInt("--> ");

        //Time for a very complicated switch choice
        switch (menuSelect){
            case 1:
                playCountFilter(0);
                break;
            case 2:
                System.out.println("Please input the minimum number of plays you would like to search for.");
                Integer minPlays = InputReader.getInt("--> ");
                playCountFilter(minPlays);
                break;
            case 3:
                addNewSong();
                break;
            case 4:
                removeSong();
                break;
            case 5:
                menuLeaveOption = true;
                break;
            default:
                System.out.println("Sorry, that wasn't a valid option, try again.");
                break;
            //I suppose that wasnt as complicated as I thought
        }

    }

    
    //Now to actually rewrite that filtering method. Should be pretty easy the second time though.
    public void playCountFilter(Integer atLeastPlays)
    {
        //This little integer here is for tracking if any songs have been found. If there arent, we'll print an error message.
        Integer goodSongsCount = 0;

        System.out.println("~~~~~~~~~~~~~");
        System.out.println("Searching...");
        
        //This will loop for as many times as there are songs in the list
        for (Integer currentIndex = 0; currentIndex < songTitles.size();)
        {
            //Each time the current play count is above the inputted minimum, this will print out that song's info, and increase 'goodSongsCount'.
            if (playCounts.get(currentIndex) >= atLeastPlays)
            {
                System.out.println(songTitles.get(currentIndex) + " by " + artistNames.get(currentIndex) + " has a play count of " + playCounts.get(currentIndex));
                System.out.println("~");
                goodSongsCount++;
            }
            currentIndex++;
        }
        
        //Now for that error message I mentioned
        if (goodSongsCount == 0)
        {
            System.out.println("Sorry, there are no songs in our database that are quite that popular.");

        }

    }
 
    

}

