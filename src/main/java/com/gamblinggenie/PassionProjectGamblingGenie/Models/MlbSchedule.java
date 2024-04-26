package com.gamblinggenie.PassionProjectGamblingGenie.Models;
import jakarta.persistence.*;

@Entity
public class MlbSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private long gamePk;
    @Column
    private String gameGuid;
    @Column
    private String link;
    @Column
    private String gameType;
    @Column
    private String season;
    @Column
    private String gameDate;
    @Column
    private String officialDate;
    @Column
    private String abstractGameState;
    @Column
    private String codedGameState;
    @Column
    private String detailedState;
    @Column
    private String statusCode;
    @Column
    private boolean startTimeTBD;
    @Column
    private String abstractGameCode;
    @Column
    private int awayWins;
    @Column
    private int awayLosses;
    @Column
    private String awayPct;
    @Column
    private int awayTeamId;
    @Column
    private String awayTeamName;
    @Column
    private boolean awaySplitSquad;
    @Column
    private int awaySeriesNumber;
    @Column
    private int homeWins;
    @Column
    private int homeLosses;
    @Column
    private String homePct;
    @Column
    private int homeTeamId;
    @Column
    private String homeTeamName;
    @Column
    private boolean homeSplitSquad;
    @Column
    private int homeSeriesNumber;
    @Column
    private int venueId;
    @Column
    private String venueName;
    @Column
    private String venueLink;
    @Column
    private String contentLink;
    @Column
    private int gameNumber;
    @Column
    private boolean publicFacing;
    @Column
    private String doubleHeader;
    @Column
    private String gamedayType;
    @Column
    private String tiebreaker;
    @Column
    private String calendarEventID;
    @Column
    private String seasonDisplay;
    @Column
    private String dayNight;
    @Column
    private int scheduledInnings;
    @Column
    private boolean reverseHomeAwayStatus;
    @Column
    private int inningBreakLength;
    @Column
    private int gamesInSeries;
    @Column
    private int seriesGameNumber;
    @Column
    private String seriesDescription;
    @Column
    private String recordSource;
    @Column
    private String ifNecessary;
    @Column
    private String ifNecessaryDescription;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGamePk() {
        return gamePk;
    }

    public void setGamePk(long gamePk) {
        this.gamePk = gamePk;
    }

    public String getGameGuid() {
        return gameGuid;
    }

    public void setGameGuid(String gameGuid) {
        this.gameGuid = gameGuid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getSeason() {
        return season;}

    public void setSeason(String season) {
        this.season = season;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public String getOfficialDate() {
        return officialDate;
    }

    public void setOfficialDate(String officialDate) {
        this.officialDate = officialDate;
    }

    public String getAbstractGameState() {
        return abstractGameState;
    }

    public void setAbstractGameState(String abstractGameState) {
        this.abstractGameState = abstractGameState;
    }

    public String getCodedGameState() {
        return codedGameState;
    }

    public void setCodedGameState(String codedGameState) {
        this.codedGameState = codedGameState;
    }

    public String getDetailedState() {
        return detailedState;
    }

    public void setDetailedState(String detailedState) {
        this.detailedState = detailedState;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isStartTimeTBD() {
        return startTimeTBD;
    }

    public void setStartTimeTBD(boolean startTimeTBD) {
        this.startTimeTBD = startTimeTBD;
    }

    public String getAbstractGameCode() {
        return abstractGameCode;
    }

    public void setAbstractGameCode(String abstractGameCode) {
        this.abstractGameCode = abstractGameCode;
    }

    public int getAwayWins() {
        return awayWins;
    }

    public void setAwayWins(int awayWins) {
        this.awayWins = awayWins;
    }

    public int getAwayLosses() {
        return awayLosses;
    }

    public void setAwayLosses(int awayLosses) {
        this.awayLosses = awayLosses;
    }

    public String getAwayPct() {
        return awayPct;
    }

    public void setAwayPct(String awayPct) {
        this.awayPct = awayPct;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public boolean isAwaySplitSquad() {
        return awaySplitSquad;
    }

    public void setAwaySplitSquad(boolean awaySplitSquad) {
        this.awaySplitSquad = awaySplitSquad;
    }

    public int getAwaySeriesNumber() {
        return awaySeriesNumber;
    }

    public void setAwaySeriesNumber(int awaySeriesNumber) {
        this.awaySeriesNumber = awaySeriesNumber;
    }

    public int getHomeWins() {
        return homeWins;
    }

    public void setHomeWins(int homeWins) {
        this.homeWins = homeWins;
    }

    public int getHomeLosses() {
        return homeLosses;
    }

    public void setHomeLosses(int homeLosses) {
        this.homeLosses = homeLosses;
    }

    public String getHomePct() {
        return homePct;
    }

    public void setHomePct(String homePct) {
        this.homePct = homePct;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public boolean isHomeSplitSquad() {
        return homeSplitSquad;
    }

    public void setHomeSplitSquad(boolean homeSplitSquad) {
        this.homeSplitSquad = homeSplitSquad;
    }

    public int getHomeSeriesNumber() {
        return homeSeriesNumber;
    }

    public void setHomeSeriesNumber(int homeSeriesNumber) {
        this.homeSeriesNumber = homeSeriesNumber;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueLink() {
        return venueLink;
    }

    public void setVenueLink(String venueLink) {
        this.venueLink = venueLink;
    }

    public String getContentLink() {
        return contentLink;
    }

    public void setContentLink(String contentLink) {
        this.contentLink = contentLink;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public boolean isPublicFacing() {
        return publicFacing;
    }

    public void setPublicFacing(boolean publicFacing) {
        this.publicFacing = publicFacing;
    }

    public String getDoubleHeader() {
        return doubleHeader;
    }

    public void setDoubleHeader(String doubleHeader) {
        this.doubleHeader = doubleHeader;
    }

    public String getGamedayType() {
        return gamedayType;
    }

    public void setGamedayType(String gamedayType) {
        this.gamedayType = gamedayType;
    }

    public String getTiebreaker() {
        return tiebreaker;
    }

    public void setTiebreaker(String tiebreaker) {
        this.tiebreaker = tiebreaker;
    }

    public String getCalendarEventID() {
        return calendarEventID;
    }

    public void setCalendarEventID(String calendarEventID) {
        this.calendarEventID = calendarEventID;
    }

    public String getSeasonDisplay() {
        return seasonDisplay;
    }

    public void setSeasonDisplay(String seasonDisplay) {
        this.seasonDisplay = seasonDisplay;
    }

    public String getDayNight() {
        return dayNight;
    }

    public void setDayNight(String dayNight) {
        this.dayNight = dayNight;
    }

    public int getScheduledInnings() {
        return scheduledInnings;
    }

    public void setScheduledInnings(int scheduledInnings) {
        this.scheduledInnings = scheduledInnings;
    }

    public boolean isReverseHomeAwayStatus() {
        return reverseHomeAwayStatus;
    }

    public void setReverseHomeAwayStatus(boolean reverseHomeAwayStatus) {
        this.reverseHomeAwayStatus = reverseHomeAwayStatus;
    }

    public int getInningBreakLength() {
        return inningBreakLength;
    }

    public void setInningBreakLength(int inningBreakLength) {
        this.inningBreakLength = inningBreakLength;
    }

    public int getGamesInSeries() {
        return gamesInSeries;
    }

    public void setGamesInSeries(int gamesInSeries) {
        this.gamesInSeries = gamesInSeries;
    }

    public int getSeriesGameNumber() {
        return seriesGameNumber;
    }

    public void setSeriesGameNumber(int seriesGameNumber) {
        this.seriesGameNumber = seriesGameNumber;
    }

    public String getSeriesDescription() {
        return seriesDescription;
    }

    public void setSeriesDescription(String seriesDescription) {
        this.seriesDescription = seriesDescription;
    }

    public String getRecordSource() {
        return recordSource;
    }

    public void setRecordSource(String recordSource) {
        this.recordSource = recordSource;
    }

    public String getIfNecessary() {
        return ifNecessary;
    }

    public void setIfNecessary(String ifNecessary) {
        this.ifNecessary = ifNecessary;
    }

    public String getIfNecessaryDescription() {
        return ifNecessaryDescription;
    }

    public void setIfNecessaryDescription(String ifNecessaryDescription) {
        this.ifNecessaryDescription = ifNecessaryDescription;
    }


}



