DESCRIPTION = "Preloadable library to improve large file operations"
SECTION = "base"

SRCREV = "2beee1fa0a267c0c847bb52af297b9d04a824019"

inherit autotools opendreambox-git lib_package

do_install_append() {
        install -d ${D}${sysconfdir}
        echo "libpagecache.so.0.0.0" > ${D}${sysconfdir}/ld.so.preload
}
