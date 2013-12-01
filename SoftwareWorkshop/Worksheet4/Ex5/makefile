PROJECT=ObjectOrientatedProgramming
TEX=pdflatex
BIBTEX=bibtex
DIR=build
BUILDTEX=$(TEX) -output-directory=$(DIR) $(PROJECT).tex

CHECKDIR=mkdir -p $(DIR)

all:
	$(CHECKDIR)
	$(BUILDTEX)
	$(BIBTEX) ${DIR}/$(PROJECT)
	$(BUILDTEX)
	$(BUILDTEX)
clean-all:
	rm -f ${DIR}/{*.dvi,*.log,*.bak,*.aux,*.bbl,*.blg,*.idx,*.ps,*.eps,*.pdf,*.toc,*.out,*~}

clean:
	rm -f ${DIR}/{*.log,*.bak,*.aux,*.bbl,*.blg,*.idx,*.toc,*.out,*~}
