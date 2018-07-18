# Selecting-one-at-a-time-dialog
Provide selection of data

Choose one option 

To get a Git project into your build:

Into build.gradle of app :

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.ChandelaDeveloper:Selecting-one-at-a-time-dialog:v1.1'
	}

---------------------------------------------------------------------------------------------------------------------------------------------------
For maven dependency:

Step 1. Add the JitPack repository to your build file
	<repositories>
		<repository>
		    <Id>jitpack. I</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

Step 2. Add the dependency

	<dependency>
	    <groupId>com.github.ChandelaDeveloper</groupId>
	    <artifactId>Selecting-one-at-a-time-dialog</artifactId>
	    <version>v1.1</version>
	</dependency>

-----------------------------------------------------------------------------------------------------------------------------------------------------

For SelectionDialog in Android:

<code>
 new SelectionBuilder(this)
                .setTitle("Hello Please select something")
                .setList(Arrays.asList(getResources().getStringArray(R.array.classes)))
                .setFont(null)
                .setTitleColor(ContextCompat.getColor(this, R.color.orange))
                .setDataTextColor(ContextCompat.getColor(this, R.color.colorAccent))
                .setCancelable(false)
                .setDataBold(true)
                .setCallBackListener(new SelectionListener() {
                    @Override
                    public void onClick(SelectionDialog dialog, int position) {
                        Toast.makeText(MainActivity.this, getResources().getStringArray(R.array.classes)[position], 
                           Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                            }).build().show();
</code>

-----------------------------------------------------------------------------------------------------------------------------------------------------

