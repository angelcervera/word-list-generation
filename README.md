# Word list generator to learn typing.

In this early stage version of the application, it will generate three files:

- Level 1 - Words that use only characters in the line 3
- Level 2 - Words that don't use characters in the line 2
- Level 3 - All words.

## Inputs.

- File with the list of words. As example, you can use one
  from [freebsd](https://svnweb.freebsd.org/csrg/share/dict/words?revision=61569&view=co)
- File with the keyboard lines. [In this example](src/test/resources/colemak-dh.txt), you can see as example the layout
  definition for my Colemak-DH.
- Output folder.
