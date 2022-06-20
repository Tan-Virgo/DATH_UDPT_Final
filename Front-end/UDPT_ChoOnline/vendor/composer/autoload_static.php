<?php

// autoload_static.php @generated by Composer

namespace Composer\Autoload;

class ComposerStaticInit51d66725ba341b8d2dda9a0c152a9a03
{
    public static $prefixLengthsPsr4 = array (
        'T' => 
        array (
            'Tobscure\\JsonApi\\' => 17,
        ),
    );

    public static $prefixDirsPsr4 = array (
        'Tobscure\\JsonApi\\' => 
        array (
            0 => __DIR__ . '/..' . '/tobscure/json-api/src',
        ),
    );

    public static $classMap = array (
        'Composer\\InstalledVersions' => __DIR__ . '/..' . '/composer/InstalledVersions.php',
    );

    public static function getInitializer(ClassLoader $loader)
    {
        return \Closure::bind(function () use ($loader) {
            $loader->prefixLengthsPsr4 = ComposerStaticInit51d66725ba341b8d2dda9a0c152a9a03::$prefixLengthsPsr4;
            $loader->prefixDirsPsr4 = ComposerStaticInit51d66725ba341b8d2dda9a0c152a9a03::$prefixDirsPsr4;
            $loader->classMap = ComposerStaticInit51d66725ba341b8d2dda9a0c152a9a03::$classMap;

        }, null, ClassLoader::class);
    }
}