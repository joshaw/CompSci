PROJECT=Assignment1
TEX=pdflatex
BIBTEX=bibtex
DIR=build
BUILDTEX=$(TEX) -output-directory=$(DIR) $(PROJECT).tex

CHECKDIR=mkdir -p $(DIR)

all:
	$(CHECKDIR)
	$(BUILDTEX)
	#$(BIBTEX) $(PROJECT)
	$(BUILDTEX)
	$(BUILDTEX)
clean-all:
	rm -f *.dvi *.log *.bak *.aux *.bbl *.blg *.idx *.ps *.eps *.pdf *.toc *.out *~

clean:
	rm -f *.log *.bak *.aux *.bbl *.blg *.idx *.toc *.out *~
