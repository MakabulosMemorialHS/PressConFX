# PressConFX

Note: This is currently a work in progress. It should be ready by
the time the Private Schools Press Conference cycle for this School Year
begins.

WHAT IS THIS?
------------

PressConFX is a rewrite of the Private Schools Press Conference Management Software (PSPCMS).

The current software suite we are using is a mix of Python, C, and Tcl/Tk programs that was first written more than ten years ago. It was designed to run on Linux. This project aims to port the PSPC Software to JavaFX. Hopefully, this port to Java8 should allow the software to run on Windows and Macs.

There are several issues that need to be resolved to achieve this.

1. PSPCMS uses LaTeX to format its printable output. LaTeX is pretty standard on Linux and has great typesetting capabilities. However, LaTeX is non-standard on Windows. Is there a standard and viable (if ugly) alternative on the Windows platform?

2. PSPCMS creates and manipulates a database which is SQLite based. Does Java 8 provide a standard JDBC engine for SQLite or is this a separate download?

