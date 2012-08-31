DESCRIPTION = "PNG Assistant"
PR = "r0"

SRC_URI = "\
	file://png_util.cpp \
	file://png_util.h \
	file://png_util.i \
"

do_compile() {
	swig -python -c++ ${WORKDIR}/png_util.i
	${CXX} -O2 -c -fPIC ${WORKDIR}/png_util.cpp ${WORKDIR}/png_util_wrap.cxx -I${STAGING_INCDIR}/python2.6
	${CXX} -shared ${WORKDIR}/png-util-1.0/png_util.o ${WORKDIR}/png-util-1.0/png_util_wrap.o -o _png_util.so -L${STAGING_LIBDIR} -lpng -fPIC
	mv ${WORKDIR}/png_util.py ${WORKDIR}/png-util-1.0
}

