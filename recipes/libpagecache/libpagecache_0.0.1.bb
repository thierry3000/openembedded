DESCRIPTION = "Preloadable library to improve large file operations"
SECTION = "base"

SRCREV = "4a34104fa6475d20f7248d46f37fb2ae216273ae"

inherit autotools opendreambox-git lib_package

do_install_append() {
        install -d ${D}${sysconfdir}
        echo "libpagecache.so.0.0.0" > ${D}${sysconfdir}/ld.so.preload
}
