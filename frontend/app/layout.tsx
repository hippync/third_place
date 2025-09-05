export const metadata = { title: "Third Place" };
export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body>
        <main
          style={{
            maxWidth: 880,
            margin: "40px auto",
            fontFamily: "system-ui, sans-serif",
          }}
        >
          {children}
        </main>
      </body>
    </html>
  );
}
