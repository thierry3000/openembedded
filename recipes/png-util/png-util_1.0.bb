DESCRIPTION = "PNG Assistant"
LICENSE = "GPLv2"
PR = "r2"

DEPENDS = "swig-native libpng python"

SRC_URI = "\
	file://png_util.cpp \
	file://png_util.h \
	file://png_util.i \
"

S = "${WORKDIR}/${P}"

inherit distutils

PYTHON_SITEPACKAGES_DIR = "${libdir}/${PYTHON_DIR}/site-packages"
do_compile() {
	swig -python -c++ ${WORKDIR}/png_util.i
	${CXX} -O2 -c -fPIC ${WORKDIR}/png_util.cpp ${WORKDIR}/png_util_wrap.cxx -I${STAGING_INCDIR}/${PYTHON_DIR}
	${CXX} -shared ${S}/png_util.o ${S}/png_util_wrap.o -o _png_util.so -L${STAGING_LIBDIR} -lpng -fPIC
	mv ${WORKDIR}/png_util.py ${S}
}

do_install() {
	install -d ${D}/${PYTHON_SITEPACKAGES_DIR}/pngutil
	touch ${D}/${PYTHON_SITEPACKAGES_DIR}/pngutil/__init__.py
	install -m 0755 ${S}/png_util.py ${D}/${PYTHON_SITEPACKAGES_DIR}/pngutil
	install -m 0755 ${S}/_png_util.so ${D}/${PYTHON_SITEPACKAGES_DIR}/pngutil
}

FILES_${PN} = "${PYTHON_SITEPACKAGES_DIR}/pngutil"
