import java.util.Scanner;

import java.sql.*;

public class Music {
	private static Scanner scan = new Scanner(System.in);
	private static int i;
	private static Connection conn;
	private static Statement stmt ;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/m2";
    
    public static void printOptions(int opt){
    	switch(opt){
    	case 1: 
    		print("Enter operation no.");
    		print("1 -> Select");
    		print("2 -> Insert");
    		print("3 -> Update");
    		print("4 -> Delete");
    		print("5 -> Join");
		    print("***************");
    		break;
    	case 2:
    		print("1  -> Artists");
    		print("2  -> Genres");
    		print("3  -> Artist: Genres");
    		print("4  -> Artist: Instruments");
    		print("5  -> Artist: Labels");
    		print("6  -> Artist: Acted Groups");
    		print("7  -> Albums");
    		print("8  -> Album Artist");
    		print("9  -> Tracks");
    		print("10 -> Track Artist");
    		print("11 -> Playlists");
		    print("***************");
    	}
    }
    
	public static void print(String toPrint){
		System.out.println(toPrint);
	}
	public static void select() throws SQLException{
		print("Enter table no. to show");
		printOptions(2);
		i = scan.nextInt();
		String dbname = "";
		switch(i){
			case 1:	dbname="artists";			break;
			case 2:	dbname="genres";			break;
			case 3:	dbname="artist_genres";		break;
			case 4:	dbname="artist_occupation";	break;
			case 5:	dbname="artist_labels";		break;
			case 6:	dbname="artist_acts";		break;
			case 7:	dbname="albums";			break;
			case 8:	dbname="album_roles";		break;
			case 9:	dbname="tracks";			break;
			case 10: dbname="track_roles";		break;
			case 11: dbname="playlist";	break;
			default:
				print("Input error! Please try again.");
				select();
		}
		print("SELECT * FROM " + dbname);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM " + dbname);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {
		    for(int k = 1; k < columnsNumber + 1; k++){
		    	System.out.print(rsmd.getColumnName(k) + ": ");
		        print(rs.getString(k));
		    }
		    print("***************");
		}
	}
	public static void insert() throws SQLException{
		print("Enter table no. to insert");
		printOptions(2);
		i = scan.nextInt();
		String query = "";
		switch(i){
			case 1:	query+="INSERT INTO  `artists`(`artistName`, `artistFullName`, `artistBirtDate`, `artistYearsActive`, `artistDescription`, `artistFollower`, `artistListenCount`) VALUES (";
				scan.nextLine();
				print("Enter Artist Name: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist Full Name: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist Birthdate: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist Years Active: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist Description: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist Follower: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist Listen Counter: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 2:	query="INSERT INTO `genres`(`genreName`, `genreDescription`) VALUES (";			
				scan.nextLine();
				print("Enter Genre Name: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Genre Description: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 3:	query="INSERT INTO `artist_genres`(`artistId`, `genreId`) VALUES (";		
				scan.nextLine();
				print("Enter Artist ID to Associate with Genre: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Genre ID  to Associate with Artist: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 4:	query="INSERT INTO `artist_occupation`(`artistId`, `occupation`) VALUES (";	
				scan.nextLine();
				print("Enter Artist ID to add Instrument: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Instrument Name: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 5:	query="INSERT INTO `artist_labels`(`artistId`, `label`) VALUES (";		
				scan.nextLine();
				print("Enter Artist ID to Associate with Label: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Label Name: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 6:	query="INSERT INTO `artist_acts`(`artistId`, `act`) VALUES (";		
				scan.nextLine();
				print("Enter Artist ID to Associate with Label: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Label Name: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 7:	query="INSERT INTO `albums`(`albumName`, `albumRelease`, `albumGenreId`, `albumPicture`, `albumProducerId`) VALUES (";			
				scan.nextLine();
				print("Enter Album Name: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Release Date: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Genre ID: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Album Picture: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Album Producer ID: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 8:	query="INSERT INTO `album_roles`(`albumId`, `artistId`, `albumRole`) VALUES (";		
				scan.nextLine();
				print("Enter Album ID to add Artist: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist ID to Associate with Album: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Role of Artist: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 9:	query="INSERT INTO `tracks`(`trackAblumId`, `trackName`, `trackListenCount`, `trackLikeCount`, `trackLyrics`) VALUES (";	
				scan.nextLine();
				print("Enter Album ID of Track: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Track Name: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Track Listen Counter: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Track Like Counter: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Song Lyricst: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 10: query="INSERT INTO `track_roles`(`trackId`, `trackArtistId`, `trackRole`) VALUES (";		
				scan.nextLine();
				print("Enter Track ID to Associate with Artist: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist ID to Associate with Track: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Role of Artist: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 11: query="INSERT INTO `playlist`(`playlistId`, `trackId`) VALUES (";
				scan.nextLine();
				print("Enter Playlist ID to add Track: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Track ID: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			default:
				print("Input error! Please try again.");
				insert();
		}
		print(query);
		PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.execute();
	}
	
	public static void update() throws SQLException{
		print("Enter table no. to update");
		printOptions(2);
		i = scan.nextInt();
		String query = "";
		switch(i){
			case 1:	query+="INSERT INTO `artists`(`artistName`, `artistFullName`, `artistBirtDate`, `artistYearsActive`, `artistDescription`, `artistFollower`, `artistListenCount`) VALUES (";
				scan.nextLine();
				print("Enter Artist Name: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist Full Name: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist Birthdate: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist Years Active: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist Description: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist Follower: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist Listen Counter: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 2:	query="INSERT INTO `genres`(`genreName`, `genreDescription`) VALUES (";			
				scan.nextLine();
				print("Enter Genre Name: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Genre Description: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 3:	query="INSERT INTO `artist_genres`(`artistId`, `genreId`) VALUES (";		
				scan.nextLine();
				print("Enter Artist ID to Associate with Genre: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Genre ID  to Associate with Artist: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 4:	query="INSERT INTO `artist_occupation`(`artistId`, `occupation`) VALUES (";	
				scan.nextLine();
				print("Enter Artist ID to add Instrument: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Instrument Name: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 5:	query="INSERT INTO `artist_labels`(`artistId`, `label`) VALUES (";		
				scan.nextLine();
				print("Enter Artist ID to Associate with Label: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Label Name: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 6:	query="INSERT INTO `artist_acts`(`artistId`, `act`) VALUES (";		
				scan.nextLine();
				print("Enter Artist ID to Associate with Label: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Label Name: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 7:	query="INSERT INTO `albums`(`albumName`, `albumRelease`, `albumGenreId`, `albumPicture`, `albumProducerId`) VALUES (";			
				scan.nextLine();
				print("Enter Album Name: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Release Date: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Genre ID: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Album Picture: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Album Producer ID: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 8:	query="INSERT INTO `album_roles`(`albumId`, `artistId`, `albumRole`) VALUES (";		
				scan.nextLine();
				print("Enter Album ID to add Artist: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist ID to Associate with Album: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Role of Artist: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 9:	query="INSERT INTO `tracks`(`trackAblumId`, `trackName`, `trackListenCount`, `trackLikeCount`, `trackLyrics`) VALUES (";	
				scan.nextLine();
				print("Enter Album ID of Track: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Track Name: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Track Listen Counter: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Track Like Counter: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Song Lyricst: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 10: query="INSERT INTO `track_roles`(`trackId`, `trackArtistId`, `trackRole`) VALUES (";		
				scan.nextLine();
				print("Enter Track ID to Associate with Artist: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Artist ID to Associate with Track: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Role of Artist: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			case 11: query="INSERT INTO `playlist`(`playlistId`, `trackId`) VALUES (";
				scan.nextLine();
				print("Enter Playlist ID to add Track: ");
				query += "\"" + scan.nextLine() + "\",";
				print("Enter Track ID: ");
				query += "\"" + scan.nextLine() + "\")";
				break;
			default:
				print("Input error! Please try again.");
				update();
		}
		print(query);
		PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.execute();
	}
	public static void main(String args[]) throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            print("Succesfully connected to database.");
    		print("Welcome to Music database!");
        }
        catch(Exception e){
            print(e.getMessage());
            System.exit(0);
        }
		for(;;){
			printOptions(1);
			i = scan.nextInt();
			switch(i){
			case 1:
				select();
				break;
			case 2:
				insert();
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				print("Input error! Please try again.");
			}
		}
	}
}
