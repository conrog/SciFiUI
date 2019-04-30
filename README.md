# SciFi UI Project

Name: Conor Rogers

Student Number: C17730535

(images/UI.png)

# Description of the assignment

For my assignemnt I decided create a user interface more specifically a Heads Up Display (HUD) for the controls of a spacecraft. I took inspiritation for my design from the recent docking of the Space X Dragon module with the International Space Station. 

There are several elements to the project which are demonstrated in the following video.

[![YouTube](https://www.youtube.com/upload_thumbnail?v=bctZhvw0bsI&t=hqdefault&ts=1556656716216)](https://youtu.be/bctZhvw0bsI)

 
# Instructions

The space craft is controlled with the following inputs :

| Input | Action |
|-----------|-----------|
| w | Pitches the spacecraft down. |
| s | Pitches the spacecraft up. |
| a | Rolls the spacecraft left. |
| d | Rolls the spacecraft right. |
| q | Yaws the spacecraft left.  |
| e | Yaws the spacecraft right.|

The velocity of the spacecraft is controlled by moving the throttle from its central deadzone. By moving it up you increase the velocity and by moving it down you decrease velocity.

The altitude of the spacecraft changes with regard to the current velocity of the ship and its current pitch.

# How it works

# What I am most proud of in the assignment

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/UI.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

