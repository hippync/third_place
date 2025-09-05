export default async function Page() {
  const res = await fetch(
    process.env.NEXT_PUBLIC_API_BASE_URL + "/actuator/health"
  ).catch(() => null);
  const health = res ? await res.json() : { status: "UNKNOWN" };
  return (
    <div>
      <h1>Third Place — Web up</h1>
      <p>
        API health: <code>{health?.status ?? "UNKNOWN"}</code>
      </p>
    </div>
  );
}
