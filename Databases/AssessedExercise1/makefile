PROJECT=AstroObjects
TEX=pdflatex
BIBTEX=bibtex
DIR=build
BUILDTEX=$(TEX) -output-directory=$(DIR) $(PROJECT).tex

CHECKDIR=mkdir -p $(DIR)

all:
	$(CHECKDIR)
	$(BUILDTEX)
	#$(BIBTEX) ${DIR}/$(PROJECT)
	$(BUILDTEX)
	$(BUILDTEX)
clean-all:
	find ${DIR}/ -type f -delete

clean:
	find ${DIR}/ -type f ! -name "*.pdf" -delete

# vim:ft=make
