gradle clean build --no-daemon
if ($LASTEXITCODE -eq 0) {
    Write-Host "`n✅ Мод собран: build\libs\GrifersTools-1.0.jar" -ForegroundColor Green
} else {
    Write-Host "`n❌ Сборка не удалась" -ForegroundColor Red
}
