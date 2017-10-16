var urlData = [4];
var q1Data = [4];
var q2Data = [4];
var q3Data = [4];
var upsData = [4];
var dwnData = [4];

urlData[0] = "";
urlData[1] = "";
urlData[2] = "";
urlData[3] = "";

q1Data[0] = 0;
q1Data[1] = 0;
q1Data[2] = 0;
q1Data[3] = 0;

q2Data[0] = 0;
q2Data[1] = 0;
q2Data[2] = 0;
q2Data[3] = 0;

q3Data[0] = 0;
q3Data[1] = 0;
q3Data[2] = 0;
q3Data[3] = 0;

upsData[0] = 0;
upsData[1] = 0;
upsData[2] = 0;
upsData[3] = 0;

upsData[0] = 0;
upsData[1] = 0;
upsData[2] = 0;
upsData[3] = 0;

dwnData[0] = 0;
dwnData[1] = 0;
dwnData[2] = 0;
dwnData[3] = 0;

var userClicked = false;
var urlIndex = setUrlIndex();

dispRatings(getUps(), getDowns()); //get up and down ratings and display them
document.getElementById("tdown").addEventListener("click", thumbsDown);
document.getElementById("tup").addEventListener("click", thumbsUp);
document.getElementById("down_per").addEventListener("mouseover", showMessageUDown);
document.getElementById("up_per").addEventListener("mouseover", showMessageUp);
document.getElementById("percents").addEventListener("mouseleave", clearMessage);
document.getElementById("submit").addEventListener("click", submitQ);

function setUrlIndex()
{
    //
    urlIndex = 0;
    return urlIndex;
}

function submitQ()
{
	"use strict";
	//var valid = true;
	var wellWritten = document.getElementsByName("wellWritten");
	var important = document.getElementsByName("important");
	var unbiased = document.getElementsByName("unbiased");
	console.log(unbiased[0].checked);
	console.log(unbiased[1].checked);
	if (!wellWritten[0].checked && !wellWritten[1].checked)
	{
		//error
		errorMessage();
	}
	else if (!important[0].checked && !important[1].checked)
	{
		//error
		errorMessage();
	}
	else if (!unbiased[0].checked && !unbiased[1].checked)
	{
		//error
		errorMessage();
	}
	else 
	{
        //var wellWrittenResults = getWellWritten();
        //var importantResults = getImportant();
        //var unbiasedResults = getUnbiased();
        //var perWellWrittenYes = wellWrittenResults[0] / (wellWritten[0] + wellWritten[1]);
        //var perWellWrittenNo = 1 - perWellWrittenYes;
        //console.log(perWellWrittenNo);
        //console.log(wellWrittenResults)
        console.log(q3Data[urlIndex]);
		document.getElementById("q1").innerHTML = '<div class="progress" style="width:85%"><div class="progress-bar progress-bar-success" role="progressbar" style="width:' +q1Data[urlIndex]+'%">Yes</div><div class="progress-bar progress-bar-danger" role="progressbar" style="width:'+(100-q1Data[urlIndex])+'%">No</div>';
		document.getElementById("q2").innerHTML = '<div class="progress" style="width:85%"><div class="progress-bar progress-bar-success" role="progressbar" style="width:' +q2Data[urlIndex]+'%">Yes</div><div class="progress-bar progress-bar-danger" role="progressbar" style="width:'+(100-q2Data[urlIndex])+'%">No</div>';
		document.getElementById("q3").innerHTML = '<div class="progress" style="width:85%"><div class="progress-bar progress-bar-success" role="progressbar" style="width:' +q3Data[urlIndex]+'%">Yes</div><div class="progress-bar progress-bar-danger" role="progressbar" style="width:'+(100-q3Data[urlIndex])+'%">No</div>';
		document.getElementById("submit").hidden = true;
		
		
	}
}

function thumbsDown() //called when element "tdown" (thumbs down image) is clicked on
{
	"use strict";
    console.log("User clicked thumbs down");
    if (!userClicked)
    {
        document.getElementById("tdown").src="img/thumbsdown_glow.png";
        userClicked = true;
        incDown();
        dispRatings(getUps(), getDowns());
    }
}

function thumbsUp() //called when element "tup" (thumbs up image) is clicked on
{
	"use strict";
    console.log("User click thumbs up");
    if (!userClicked)
    {
        document.getElementById("tup").src="img/thumbsup_glow.png";
        userClicked = true;
        incUps();
        dispRatings(getUps(), getDowns());
    }
}

function dispRatings($up, $down) //displays rating and calculates percentages
{
	"use strict";
    var percentUps;
    var percentDowns;
    if ($up !== 0 || $down !== 0)
    {
        percentUps = $up / ($up + $down);
        percentDowns = 1 - percentUps;
    }
    else 
    {
        percentUps = 0;
        percentDowns = 0;
    }
    document.getElementById("down_count").innerHTML = $down;
    document.getElementById("up_count").innerHTML = $up;
    document.getElementById("down_per").innerHTML = (100 * percentDowns).toPrecision(3) + '%';
    document.getElementById("up_per").innerHTML = (100 * percentUps).toPrecision(3) + '%';

    var maxOpacity = 0.85;
    var minOpacity = 0.15;
    //set opacity for down thumb
    if (percentDowns >= minOpacity && percentDowns <= maxOpacity)
    {
        document.getElementById("tdown").style.opacity = percentDowns;
    }
    else if (percentDowns < minOpacity)
    {
        document.getElementById("tdown").style.opacity = minOpacity;
    }
    else 
    {
        document.getElementById("tdown").style.opacity = maxOpacity;
    }

    //set opacity for up thumb
    if (percentUps >= minOpacity && percentUps <= maxOpacity)
    {
        document.getElementById("tup").style.opacity = percentUps;
    }
    else if (percentUps < minOpacity)
    {
        document.getElementById("tup").style.opacity = minOpacity;
    }
    else 
    {
        document.getElementById("tup").style.opacity = maxOpacity;
    }
}

function showMessageUp()
{
	"use strict";
    document.getElementById("perDescription").innerHTML = "This means " + document.getElementById("up_per").innerHTML + " of users did found this page reliable.";
}

function showMessageUDown()
{
	"use strict";
    document.getElementById("perDescription").innerHTML = "This means " + document.getElementById("down_per").innerHTML + " of users did not found this page reliable.";
}

function clearMessage()
{
	"use strict";
    document.getElementById("perDescription").innerHTML = "Hover over percentage for description.";
}

function errorMessage()
{
	"use strict";
	document.getElementById("perDescription").innerHTML = "You must have answered all questions before submitting.";
}

function getUps() //return ups
{
	"use strict";
    var $up = upsData[urlIndex];//change later
    //get ups from data
    //change td element with id of "up_count"
    return $up;
}

function getDowns() //returns down
{
	"use strict";
    var $down = dwnData[urlIndex];//change later
    //gets downs from database
    //change td element with id of "down_count"
    return $down;
}

function incUps() //increments up count
{
    //send to database +1 ups
    upsData[urlIndex]++;
}

function incDown() //increments down count
{
    //send to database +1 downs
    dwnData[urlIndex]++;
}

function getWellWritten()
{
    var ans1;
    ans1 = q1Data[urlIndex];

    return ans1;
}

function getImportant()
{
    //
    var ans2;
    ans2 = q2Data[urlIndex];
    return ans2;
}

function getUnbiased()
{
    var ans3;
    ans3 = q3Data[urlIndex];
    console.log(q3Data[0]);
    console.log(ans3);
    return ans3;
}